package com.ndh.pojo;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.Phongchieu;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(Chongoi.class)
public class Chongoi_ { 

    public static volatile SingularAttribute<Chongoi, String> soGhe;
    public static volatile SingularAttribute<Chongoi, Phongchieu> phongChieuID;
    public static volatile SingularAttribute<Chongoi, Integer> choNgoiID;
    public static volatile SetAttribute<Chongoi, ChongoiSuatchieu> chongoiSuatchieuSet;

}