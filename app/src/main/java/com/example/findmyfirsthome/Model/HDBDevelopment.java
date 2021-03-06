package com.example.findmyfirsthome.Model;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

public class  HDBDevelopment {
    private String developmentName;
    private String developmentDescription;
    private boolean affordable;
    private LatLng coordinates;
    private ArrayList<MapData> amenities;
    private ArrayList developmentDetails ;
    private ArrayList<HDBFlatType> hdbFlatTypeList;
    //HDBDevelopment is aggregated to FlatType , hence FlatType is added through reference not created here.
    private ArrayList<HashMap<String, Object>> hdbFlatTypeDetailsList;
    private ArrayList<ArrayList> amenitiesDetailsList;
    private String imgUrl;


    public HDBDevelopment(ArrayList<HashMap<String, Object>> flatTypeList, String developmentName, String developmentDescription,
                          boolean affordable, LatLng coordinates, ArrayList<MapData> amenities, String imgUrl)
    {
        hdbFlatTypeList = new ArrayList<>();
        amenitiesDetailsList = new ArrayList<>();

        //set data
        setHDBFlatTypeList(flatTypeList);
        this.developmentName = developmentName;
        this.developmentDescription = developmentDescription;
        this.affordable = affordable;
        this.coordinates = coordinates;
        this.amenities = amenities;
        this.imgUrl = imgUrl;
    }

    public ArrayList<ArrayList> getAmenititesDetailsList()
    {
        amenitiesDetailsList = new ArrayList<>();

        for (MapData amenity : amenities)
        {
            amenitiesDetailsList.add(amenity.getMapdataDetails());
        }

        return amenitiesDetailsList;
    }

    //hdbFlatTypeDetailsList GET, added through reference.
    public ArrayList<HashMap<String, Object>> getHDBFlatTypeDetailsList(ArrayList<HDBFlatType> hdbFlatTypeList)
    {
        hdbFlatTypeDetailsList = new ArrayList<>();

        for(HDBFlatType flat: hdbFlatTypeList ){
            this.hdbFlatTypeDetailsList.add(flat.getFlatTypeDetails());
        }

        return this.hdbFlatTypeDetailsList;

    }

    //hdbFlatTypeList get FlatTypeList in strings and objects
    public ArrayList<HashMap<String, Object>> getHDBFlatTypeDetailsList()
    {
        //initialize
        this.hdbFlatTypeDetailsList = new ArrayList<HashMap<String, Object>>();

        //get HashMap of data of each HDBFlatType
        for(HDBFlatType hdbFlatType : hdbFlatTypeList)
        {
            this.hdbFlatTypeDetailsList.add(hdbFlatType.getFlatTypeDetails());
        }

        return this.hdbFlatTypeDetailsList;
    }

    //hdbFlatTypeList CREATE FlatType
    public void setHDBFlatTypeList(ArrayList<HashMap<String, Object>> flatTypeList)
    {
        for(HashMap<String, Object>  hdbFlatTypeDetails :  flatTypeList)
        {
            //create HDBFlatType and add into the ArrayList
            this.hdbFlatTypeList.add(new HDBFlatType(hdbFlatTypeDetails));
        }
    }

    //developmentName GET SET
    public String getDevelopmentName()
    {
        return this.developmentName;
    }

    public void setDevelopmentName(String developmentName)
    {
       this.developmentName = developmentName;
    }

    //developmentDescription GET SET
    public String getDevelopmentDescription()
    {
        return this.developmentDescription;
    }

    public void setDevelopmentDescription(String developmentDescription)
    {
        this.developmentDescription = developmentDescription;
    }

    //affordable GET SET
    public Boolean getAffordable()
    {
        return this.affordable;
    }

    public void setAffordable(Boolean affordable)
    {
        this.affordable = affordable;
    }

    //coordinates GET SET
    public LatLng getCoordinates()
    {
        return this.coordinates;
    }

    public void setCoordinates(LatLng coordinates)
    {
        this.coordinates = coordinates;
    }

    //amenities GET SET
    public ArrayList<MapData> getAmenities()
    {
        return this.amenities;
    }

    public void setAmenities(ArrayList<MapData> amenities)
    {
        this.amenities = amenities;
    }

    public void setHdbFlatTypeList(ArrayList<HDBFlatType> hdbFlatTypeList) {
        this.hdbFlatTypeList = hdbFlatTypeList;
    }

    public ArrayList<HDBFlatType> getHdbFlatTypeList() {
        return hdbFlatTypeList;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public ArrayList getDevelopmentDetails()
    {
        //initialize
        this.developmentDetails = new ArrayList();

        //put them in ArrayList as ArrayList object does not inherit from Object class so cannot use HashMap
        //added into ArrayList in order like the order of the attributes in this class
        this.developmentDetails.add(getHDBFlatTypeDetailsList(getHdbFlatTypeList()));
        this.developmentDetails.add(this.developmentName);
        this.developmentDetails.add(this.developmentDescription);
        this.developmentDetails.add(this.affordable);
        this.developmentDetails.add(this.coordinates);
        this.developmentDetails.add(this.amenities);

        return developmentDetails;
    }

}


