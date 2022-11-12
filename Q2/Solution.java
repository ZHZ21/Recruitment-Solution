import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        Input the file name
        String filepath = "";
        List<String> info = readTxtFileIntoStringArrList(filepath);
//        Get the result
        List<String> result = getInfo(info);
//        Print the result
        System.out.println(result.get(0));
        for(int i = 1; i<result.size()-1; i++){
            System.out.print(result.get(i)+" ");
        }
    }

    public static List<String> getInfo (List<String> info){

        List<String> result = new ArrayList<>();
        int length = info.size();
        for(int i = 0; i<length;i++){
            String[] line = info.get(i).split(" ");
            if(line[1].equals("false")){
                result.set(0,"NO");
                result.add(line[2]);
            }
        }
        return result;
    }


    public static List<String> readTxtFileIntoStringArrList(String filePath)
    {
        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("No File");
            }
        }
        catch (Exception e)
        {
            System.out.println("Wrong");
            e.printStackTrace();
        }

        return list;
    }
}