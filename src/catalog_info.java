/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class catalog_info {
    int catalogID;
    String Imagepath,DressName;
    public catalog_info(int catalogID, String Imagepath, String DressName){
        this.catalogID = catalogID;
        this.Imagepath = Imagepath;
        this.DressName = DressName;
    }
    
    public int get_catalogID(){
        return catalogID;
    }
    public String get_Imagepath(){
        return Imagepath;
    }
    public String get_DressName(){
        return DressName;
    }
}
