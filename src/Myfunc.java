
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Myfunc {
     public ImageIcon resizePic(String PicPath,byte[] BLOBpic,int wdth,int hgt){
         ImageIcon myImg;
         if(PicPath!=null){
          myImg=new ImageIcon(PicPath);
         }else{
           myImg=new ImageIcon(BLOBpic);  
         }
       
       Image img=myImg.getImage().getScaledInstance(wdth,hgt,Image.SCALE_SMOOTH);
       ImageIcon MyPicture=new ImageIcon(img);
        return MyPicture;
    }
     public String browseImage(JLabel lbl)
     {
         String path=null;
            JFileChooser filec=new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        //file extension
        FileNameExtensionFilter fileFilter; 
        fileFilter = new FileNameExtensionFilter("*.images","png","jpg","gif");
        filec.addChoosableFileFilter(fileFilter);
        int fileState=filec.showSaveDialog(null);
        
        //if user select a file
        if(fileState == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            //imagePth=path;
            //display the image in the jlabel using resize image
            
            lbl.setIcon(resizePic(path,null,lbl.getWidth(),lbl.getHeight()));
            
            //jLabelPic.setIcon(new ImageIcon(path));
        }
        //if user cancels
        else if(fileState == JFileChooser.CANCEL_OPTION){
            System.out.println("No image selected");
        } 
        return path;
     }
     
}
