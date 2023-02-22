package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;


public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature methodSignature=null;
        List<String> list=new ArrayList<>();
        List<MethodSignature.Argument> listArgum=new ArrayList<>();
        MethodSignature.Argument argument=null;
        String[] words=signatureString.split("[()]");
        int i=0;
        for (String word: words) {
            if(i==0){
                for (String item: word.split(" ")) {
                    list.add(item);
                }
                i++;
            }else{
                String[] arr= word.split("(\\s)|(\\W\\s)");
                for (int j=0; j<arr.length-1; j=j+2){
                    argument=new MethodSignature.Argument(arr[j],arr[j+1]);
                    listArgum.add(argument);
                }
            }
        }

        if(list==null){
            throw new UnsupportedOperationException("You should implement this method.");
        }

        methodSignature=new MethodSignature(list.get(list.size()-1),listArgum);
        if(list.size()==2){
            methodSignature.setAccessModifier(null);
            methodSignature.setReturnType(list.get(0));
            methodSignature.setMethodName(list.get(1));
        }else{
            methodSignature.setAccessModifier(list.get(0));
            methodSignature.setReturnType(list.get(1));
            methodSignature.setMethodName(list.get(2));
        }





       return methodSignature;
    }
}
