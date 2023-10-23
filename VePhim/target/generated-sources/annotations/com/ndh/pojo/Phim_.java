package com.ndh.pojo;

import com.ndh.pojo.Suatchieu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(Phim.class)
public class Phim_ { 

    public static volatile SingularAttribute<Phim, String> thoiLuong;
    public static volatile SingularAttribute<Phim, String> anhPhim;
    public static volatile SingularAttribute<Phim, String> tenPhim;
    public static volatile SingularAttribute<Phim, Date> ngayPhatHanh;
    public static volatile SetAttribute<Phim, Suatchieu> suatchieuSet;
    public static volatile SingularAttribute<Phim, String> moTa;
    public static volatile SingularAttribute<Phim, Integer> phimID;

}