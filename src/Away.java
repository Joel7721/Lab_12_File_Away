import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class Away {

        public static void main(String[] args) {
            JFileChooser chooser = new JFileChooser();
            File selectedFile;
            String line ="";
            ArrayList<String> lines = new ArrayList<>();

            try {
                File workingDirectory = new File(System.getProperty("user.dir"));

                chooser.setCurrentDirectory(workingDirectory);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();
                    //Path path = Paths.get();


                    InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    int length = 0;
                    int lineNumber = 0;
                    while(reader.ready()){
                        line = reader.readLine();
                        lines.add(line);
                        lineNumber++;
                        System.out.printf("\n %-4d ----> %-60s",lineNumber, line);
                        length = length + line.length();
                    }

                    System.out.println(" ");

                    System.out.println("The number of characters is: " + length);

                    System.out.println(" ");

                    System.out.println("The number of lines is " + lineNumber);

                    int counter = 0;

                    for(String l: lines){
                        String[] words = l.split(" ");
                        for(String word: words){
                            //System.out.printf("%11s", word.trim());
                            counter++;
                        }
                        System.out.println("");
                    }

                    System.out.println("The number of words is: " + counter);

                    System.out.println(" ");
                    System.out.println("The name of the file is: " + chooser);

                } else {
                    //if an error occured or the  user canceled
                    System.out.println("Failed to choose a file to process.");
                    System.out.println("Run the program again.");
                    System.exit(0);

                }
            }
            //chooser.showOpenDialog(null); //Opens the File chooser

            catch(IOException ex){
                ex.printStackTrace();
            }



        }
    }


