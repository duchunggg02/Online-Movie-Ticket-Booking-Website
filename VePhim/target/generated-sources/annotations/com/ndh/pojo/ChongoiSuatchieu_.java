package com.ndh.pojo;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.ChongoiVe;
import com.ndh.pojo.Suatchieu;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(ChongoiSuatchieu.class)
public class ChongoiSuatchieu_ { 

    public static volatile SingularAttribute<ChongoiSuatchieu, Integer> choNgoiSuatChieuID;
    public static volatile SingularAttribute<ChongoiSuatchieu, Boolean> trangThai;
    public static volatile SingularAttribute<ChongoiSuatchieu, Chongoi> choNgoiID;
    public static volatile SetAttribute<ChongoiSuatchieu, ChongoiVe> chongoiVeSet;
    public static volatile SingularAttribute<ChongoiSuatchieu, Suatchieu> suatChieuID;

}