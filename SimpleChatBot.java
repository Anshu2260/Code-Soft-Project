package chatBot;

import java.io.IOException;
import java.util.Scanner;

public class SimpleChatBot {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("hello i'm a chatbot, ask me anything");

        while (true){
            System.out.print("user :");
            String user= sc.nextLine();
            if (user.equals("hello")){
                System.out.println("bot :hello, how can i help you");

            }if(user.equals("Tell me a joke")||user.equals("tell me a joke")){
                System.out.println("bot : \n1 = I said to the Gym instructor “Can you teach me to do the splits?” He said, “How flexible are you?” I said, “I can’t make Tuesdays.");
                System.out.println("2= I’m on a whiskey diet. I’ve lost three days already..");


            }else if(user.equals("Open Media Player")||user.equals("open media player")){

                Runtime r=Runtime.getRuntime();
                try {
                    r.exec("C:\\Program Files\\Windows Media Player\\wmplayer.exe");
                }catch (IOException i){
                    System.out.println(i);
                }

            }else if(user.equals("top five future option in a cs")){
                System.out.println("Top 5 Career Options After Computer Science Engineering");
                System.out.println("1 :  Artificial Intelligence & Machine Learning");
                System.out.println("2 :  2. Cybersecurity Engineering");
                System.out.println("3 :  Data Engineering");
                System.out.println("4 :  Data Engineering");
                System.out.println("5 :  Data Engineering");
            } else if (user.equals("play music")) {
                music m=new music();
                
            }else if(user.equals("exit")){
                break;
            }
        }



    }
}
