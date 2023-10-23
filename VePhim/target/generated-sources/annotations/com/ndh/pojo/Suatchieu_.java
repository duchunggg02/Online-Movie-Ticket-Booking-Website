package com.ndh.pojo;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.Phim;
import com.ndh.pojo.Phongchieu;
import com.ndh.pojo.Ve;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(Suatchieu.class)
public class Suatchieu_ { 

    public static volatile SingularAttribute<Suatchieu, Integer> giaTien;
    public static volatile SingularAttribute<Suatchieu, Date> gioChieu;
    public static volatile SingularAttribute<Suatchieu, Phongchieu> phongChieuID;
    public static volatile SingularAttribute<Suatchieu, Date> ngayChieu;
    public static volatile SetAttribute<Suatchieu, Ve> veSet;
    public static volatile SingularAttribute<Suatchieu, Integer> suatChieuID;
    public static volatile SingularAttribute<Suatchieu, Phim> phimID;
    public static volatile SetAttribute<Suatchieu, ChongoiSuatchieu> chongoiSuatchieuSet;

}