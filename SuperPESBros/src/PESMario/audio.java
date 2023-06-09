package PESMario;

//Java program to play an Audio
//file using Clip Object
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class audio
{

	// to store current position
	Long currentFrame;
	Clip clip;
	
	// current status of clip
	String status;
	
	AudioInputStream audioInputStream;
	static String filePath;

	// constructor to initialize streams and clip
	public audio()
	throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		// create AudioInputStream object
		audioInputStream =	AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		
		// create clip reference
		clip = AudioSystem.getClip();
		
		// open audioInputStream to the clip
		clip.open(audioInputStream);
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public static void playAudio()
	{
		try
		{
			filePath = "D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/media/background.wav";
			audio audioPlayer =	new audio();
			
			audioPlayer.play();
		}
		
		catch (Exception ex)
		{
			//System.out.println("Error with playing sound.");
			ex.printStackTrace();
		
		}
	}
	
	// Method to play the audio
	public void play()
	{
		//start the clip
		clip.start();
		
		status = "play";
	}
	
    // Method to pause the audio
    public void pause() 
    {
        if (status.equals("paused")) 
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = 
        this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }
}

