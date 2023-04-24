package com.rrlira96.juntossomosmaischallenge.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final Map<String, String> STATE_REGION_BR = new HashMap<>();
    private static final String NORTE = "norte";
    private static final String NORDESTE = "nordeste";
    private static final String CENTRO_OESTE = "centro-oeste";
    private static final String SUDESTE = "sudeste";
    private static final String SUL = "sul";

    static {
        STATE_REGION_BR.put("acre", NORTE);
        STATE_REGION_BR.put("alagoas", NORDESTE);
        STATE_REGION_BR.put("amapá", NORTE);
        STATE_REGION_BR.put("amazonas", NORTE);
        STATE_REGION_BR.put("bahia", NORDESTE);
        STATE_REGION_BR.put("ceará", NORDESTE);
        STATE_REGION_BR.put("distrito federal", CENTRO_OESTE);
        STATE_REGION_BR.put("espírito santo", SUDESTE);
        STATE_REGION_BR.put("goiás", CENTRO_OESTE);
        STATE_REGION_BR.put("maranhão", NORDESTE);
        STATE_REGION_BR.put("mato grosso", CENTRO_OESTE);
        STATE_REGION_BR.put("mato grosso do sul", CENTRO_OESTE);
        STATE_REGION_BR.put("minas gerais", SUDESTE);
        STATE_REGION_BR.put("pará", NORTE);
        STATE_REGION_BR.put("paraíba", NORDESTE);
        STATE_REGION_BR.put("paraná", SUL);
        STATE_REGION_BR.put("pernambuco", NORDESTE);
        STATE_REGION_BR.put("piauí", NORDESTE);
        STATE_REGION_BR.put("rio de janeiro", SUDESTE);
        STATE_REGION_BR.put("rio grande do norte", NORDESTE);
        STATE_REGION_BR.put("rio grande do sul", SUL);
        STATE_REGION_BR.put("rondônia", NORTE);
        STATE_REGION_BR.put("roraima", NORTE);
        STATE_REGION_BR.put("santa catarina", SUL);
        STATE_REGION_BR.put("são paulo", SUDESTE);
        STATE_REGION_BR.put("sergipe", NORDESTE);
        STATE_REGION_BR.put("tocantins", NORTE);
    }

    public static final Map<String, String> COUNTRY_CODE = new HashMap<>();

    static {
        COUNTRY_CODE.put("BR","+55");
    }

    public static final String DEFAULT_PAGE_NUMBER = "1";
    public static final String DEFAULT_PAGE_SIZE = "50";

    public static final Double SPECIAL_MIN_LAT = -46.361899;
    public static final Double SPECIAL_MAX_LAT = -34.276938;
    public static final Double SPECIAL_MIN_LON = -2.196998;
    public static final Double SPECIAL_MAX_LON = -15.411580;
    public static final Double SPECIAL_2_MIN_LAT = -52.997614;
    public static final Double SPECIAL_2_MAX_LAT = -44.428305;
    public static final Double SPECIAL_2_MIN_LON = -19.766959;
    public static final Double SPECIAL_2_MAX_LON = -23.966413;

    public static final Double NORMAL_MIN_LAT = -54.777426;
    public static final Double NORMAL_MAX_LAT = -46.603598;
    public static final Double NORMAL_MIN_LON = -26.155681;
    public static final Double NORMAL_MAX_LON = -34.016466;


}
