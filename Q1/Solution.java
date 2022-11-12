package demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args)  {
        Scanner sc =new Scanner(System.in);

//        读入库存数量
        String s1 = sc.nextLine();
        int stockNum = Integer.parseInt(s1);

//        读入库存
        String str=sc.nextLine();
        System.out.println(str);
        String [] stock = str.split(" ");


//        读入需求数量
        String s2 = sc.nextLine();
        int requestNum = Integer.parseInt(s2);

//        读入request
        String str1=sc.nextLine();
        System.out.println(str1);
        String [] request = str1.split(" ");


        String output = getRequest(stockNum,requestNum,stock,request);
        System.out.println("The output is :" + output);
    }

    public static String  getRequest(int stockNum, int requestNum, String[] Stock, String[] Request) {
        String yes = "yes";
        String no = "no";

        int lowerBound = 0;
        int higherBound = 0;
        int tag = 0;
        for (int i = 0; i < requestNum; i++) {
            int templowBound = 0;
            int temphighBound = 0;
            int temp = 0;
            if (Request[i].contains("M")) {
                temp = 2;
            } else if (Request[i].contains("L")) {
                temp = 3;
                temphighBound = pattern(Request[i], "X");
            } else if (Request[i].contains("S")) {
                temp = 1;
                templowBound = pattern(Request[i], "X");
            }
            if (temp > tag) {
                tag = temp;
            }
            if (temphighBound > higherBound) {
                higherBound = temphighBound;
            }
            if (templowBound < lowerBound) {
                lowerBound = templowBound;
            }
        }

        int stockTag = 0;
        int stockHighbound = 0;
        int stockLowbound = 0;
        for (int i = 0; i < stockNum; i++) {
            int stocktemplowBound = 0;
            int stocktemphighBound = 0;
            int stockTemp = 0;
            if (Stock[i].contains("M")) {
                stockTemp = 2;
            } else if (Stock[i].contains("L")) {
                stockTemp = 3;
                stocktemphighBound = pattern(Stock[i], "X");
            } else if (Stock[i].contains("S")) {
                stockTemp = 1;
                stocktemplowBound = pattern(Stock[i], "X");
            }
            if (stockTemp > stockTag) {
                stockTag = stockTemp;
            }
            if (stocktemphighBound > stockHighbound) {
                stockHighbound = stocktemphighBound;
            }
            if (stocktemplowBound < stockLowbound) {
                stockLowbound = stocktemplowBound;
            }
        }


        if (stockTag > tag) {
            return yes;
        } else if (stockTag == tag) {
            if (tag == 3) {
                if (stockHighbound >= higherBound) {
                    return yes;
                } else {
                    return no;
                }
            } else if (tag == 2) {
                return yes;
            } else if (tag == 1) {
                if (stockLowbound <= lowerBound) {
                    return yes;
                } else {
                    return no;
                }
            }
        } else {
            return no;
        }
        return "Wrong";
    }

    private static int pattern(String text, String size) {
        // 根据指定的字符构建正则
        Pattern pattern = Pattern.compile(size);
        // 构建字符串和正则的匹配
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        // 循环依次往下匹配
        while (matcher.find()){ // 如果匹配,则数量+1
            count++;
        }
        return  count;
    }
    

    }
