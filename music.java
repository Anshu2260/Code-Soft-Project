package chatBot;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class music{
    music(){

        File file=new File("D:\\CodeSoftPRoject\\SimpleChatBot\\Such Keh Raha Hai.wav");
        try(AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(file)) {

            Clip clip =AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            System.out.println("no problam");

        } catch (FileNotFoundException f){
            System.out.println(f);
        }catch (UnsupportedAudioFileException u){
            System.out.println(u);
        }catch (LineUnavailableException l){
            System.out.println(l);
        } catch (IOException i){
            System.out.println(i);
        }


    }

    public static void main(String[] args) {
        music m=new music();
    }
}