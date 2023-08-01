package com.helloworldgroup.helloworld.controller;

import com.helloworldgroup.helloworld.functionalinterface.College;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method =  RequestMethod.GET)
    public String getHello(@RequestParam(name = "val", defaultValue = "0") String val){
        System.out.println(val);
        return "Hello " + val;
    }

    @RequestMapping(value = "/hello1/{val1}", method =  RequestMethod.GET)
    public String getHello2(@PathVariable int val1){
        System.out.println(val1);
        return "Hello " + String.valueOf(5/val1);
    }

    @GetMapping("reverseString")
    public ResponseEntity<String> reverseString(@RequestParam String str){
        /*String newStr = "";
        for(int i=str.length()-1; i>=0;i--){
            newStr +=  str.charAt(i);
        }
        return new ResponseEntity<>(newStr, HttpStatus.OK);
        */
        StringBuffer builder = new StringBuffer(str);
        return new ResponseEntity<>(builder.reverse().toString(), HttpStatus.OK);
    }

    @GetMapping("firstNonRepeatingChar")
    public ResponseEntity<Character> findFirstNonRepeatingChar(@RequestParam String str){
        char result = 0;
        for(int i = 0; i<str.length();i++){
            if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                result = str.charAt(i);
                break;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("firstRepeatingChar")
    public ResponseEntity<Character> findFirstRepeatingChar(@RequestParam String str){
        char result = 0;
        for(int i = 0; i<str.length();i++){
            if(str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))){
                result = str.charAt(i);
                break;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("findduplicate")
    public ResponseEntity<char[]> findDuplicate(@RequestParam String str1){
        char[] resArr = {};
        char[] str = str1.toCharArray();
        for(int i=0; i<str.length;i++){
            int count = 1;
            for(int j=i+1;j<str.length;j++){
                if(str[i] == str[j] && str[i] != ' '){
                    count++;
                    str[j]='0';
                }
            }
            if(count>1 && str[i] != '0'){
                System.out.println(str[i]);
                resArr = Arrays.copyOf(resArr, resArr.length+1);
                resArr[resArr.length-1] = str[i];
             }


        }

        System.out.println(resArr);


        return new ResponseEntity<>(resArr, HttpStatus.OK);

    }

    public static void main(String[] args) {

        ///functional interface
        College myFunctionalInterface = (int x) -> {return x*x;};
        System.out.println(myFunctionalInterface.calculate(20));
    }
}
