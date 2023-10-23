package com.ndh.pojo;

import com.ndh.pojo.ChongoiVe;
import com.ndh.pojo.Nguoidung;
import com.ndh.pojo.Phanhoi;
import com.ndh.pojo.Suatchieu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(Ve.class)
public class Ve_ { 

    public static volatile SingularAttribute<Ve, Boolean> tinhTrang;
    public static volatile SetAttribute<Ve, Phanhoi> phanhoiSet;
    public static volatile SingularAttribute<Ve, Date> ngayDat;
    public static volatile SingularAttribute<Ve, String> phuongThucThanhToan;
    public static volatile SetAttribute<Ve, ChongoiVe> chongoiVeSet;
    public static volatile SingularAttribute<Ve, Integer> veID;
    public static volatile SingularAttribute<Ve, Nguoidung> nguoiDungID;
    public static volatile SingularAttribute<Ve, Integer> gia;
    public static volatile SingularAttribute<Ve, Suatchieu> suatChieuID;

}