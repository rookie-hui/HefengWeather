package com.example.weathertest11;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jason.fang on 2016/4/19.
 */
public class WeatherBean {
    @Override
    public String toString() {
        return "WeatherBean{" +
                "service=" + service +
                '}';
    }

    /**
     * aqi : {"city":{"aqi":"59","co":"0","no2":"36","o3":"74","pm10":"59","pm25":"39","qlty":"良","so2":"2"}}
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-04-18 21:01","utc":"2016-04-18 13:01"}}
     * daily_forecast : [{"astro":{"sr":"05:31","ss":"18:55"},"cond":{"code_d":"100","code_n":"104","txt_d":"晴","txt_n":"阴"},"date":"2016-04-18","hum":"8","pcpn":"0.0","pop":"1","pres":"1013","tmp":{"max":"22","min":"8"},"vis":"10","wind":{"deg":"316","dir":"无持续风向","sc":"微风","spd":"3"}},{"astro":{"sr":"05:30","ss":"18:56"},"cond":{"code_d":"305","code_n":"104","txt_d":"小雨","txt_n":"阴"},"date":"2016-04-19","hum":"20","pcpn":"1.3","pop":"84","pres":"1015","tmp":{"max":"15","min":"8"},"vis":"10","wind":{"deg":"168","dir":"无持续风向","sc":"微风","spd":"10"}},{"astro":{"sr":"05:28","ss":"18:57"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2016-04-20","hum":"12","pcpn":"0.0","pop":"16","pres":"1011","tmp":{"max":"26","min":"12"},"vis":"10","wind":{"deg":"26","dir":"无持续风向","sc":"微风","spd":"2"}},{"astro":{"sr":"05:27","ss":"18:58"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-04-21","hum":"11","pcpn":"0.0","pop":"0","pres":"1003","tmp":{"max":"29","min":"15"},"vis":"10","wind":{"deg":"308","dir":"北风","sc":"3-4","spd":"12"}},{"astro":{"sr":"05:25","ss":"18:59"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-04-22","hum":"11","pcpn":"0.0","pop":"0","pres":"1009","tmp":{"max":"24","min":"11"},"vis":"10","wind":{"deg":"307","dir":"无持续风向","sc":"微风","spd":"0"}},{"astro":{"sr":"05:24","ss":"19:00"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-04-23","hum":"7","pcpn":"0.0","pop":"0","pres":"1012","tmp":{"max":"23","min":"11"},"vis":"10","wind":{"deg":"291","dir":"无持续风向","sc":"微风","spd":"6"}},{"astro":{"sr":"05:23","ss":"19:01"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-04-24","hum":"15","pcpn":"0.2","pop":"42","pres":"1010","tmp":{"max":"26","min":"13"},"vis":"10","wind":{"deg":"201","dir":"无持续风向","sc":"微风","spd":"7"}}]
     * hourly_forecast : [{"date":"2016-04-18 22:00","hum":"14","pop":"0","pres":"1016","tmp":"18","wind":{"deg":"215","dir":"西南风","sc":"微风","spd":"9"}}]
     * now : {"cond":{"code":"101","txt":"多云"},"fl":"14","hum":"23","pcpn":"0","pres":"1013","tmp":"15","vis":"10","wind":{"deg":"170","dir":"西南风","sc":"3-4","spd":"10"}}
     * status : ok
     * suggestion : {"comf":{"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"易发","txt":"相对于今天将会出现大幅度降温，易发生感冒，注意增加衣服，加强自我防护避免感冒。"},"sport":{"brf":"较不宜","txt":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意保暖并携带雨具。"},"trav":{"brf":"适宜","txt":"温度适宜，又有较弱降水和微风作伴，会给您的旅行带来意想不到的景象，适宜旅游，可不要错过机会呦！"},"uv":{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}}
     */

    @SerializedName("HeWeather data service 3.0")
    public List<HeWeatherDataServiceBean> service;

    public static class HeWeatherDataServiceBean {

        @Override
        public String toString() {
            return "HeWeatherDataServiceBean{" +
                    "aqi=" + aqi +
                    ", basic=" + basic +
                    ", now=" + now +
                    ", status='" + status + '\'' +
                    ", suggestion=" + suggestion +
                    ", dailyForecast=" + dailyForecast +
                    ", hourlyForecast=" + hourlyForecast +
                    '}';
        }

        /**
         * city : {"aqi":"59","co":"0","no2":"36","o3":"74","pm10":"59","pm25":"39","qlty":"良","so2":"2"}
         */

        @SerializedName("aqi")
        public AqiBean aqi;
        /**
         * city : 北京
         * cnty : 中国
         * id : CN101010100
         * lat : 39.904000
         * lon : 116.391000
         * update : {"loc":"2016-04-18 21:01","utc":"2016-04-18 13:01"}
         */

        @SerializedName("basic")
        public BasicBean basic;
        /**
         * cond : {"code":"101","txt":"多云"}
         * fl : 14
         * hum : 23
         * pcpn : 0
         * pres : 1013
         * tmp : 15
         * vis : 10
         * wind : {"deg":"170","dir":"西南风","sc":"3-4","spd":"10"}
         */

        @SerializedName("now")
        public NowBean now;
        @SerializedName("status")
        public String status;
        /**
         * comf : {"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
         * cw : {"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
         * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
         * flu : {"brf":"易发","txt":"相对于今天将会出现大幅度降温，易发生感冒，注意增加衣服，加强自我防护避免感冒。"}
         * sport : {"brf":"较不宜","txt":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意保暖并携带雨具。"}
         * trav : {"brf":"适宜","txt":"温度适宜，又有较弱降水和微风作伴，会给您的旅行带来意想不到的景象，适宜旅游，可不要错过机会呦！"}
         * uv : {"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}
         */

        @SerializedName("suggestion")
        public SuggestionBean suggestion;
        /**
         * astro : {"sr":"05:31","ss":"18:55"}
         * cond : {"code_d":"100","code_n":"104","txt_d":"晴","txt_n":"阴"}
         * date : 2016-04-18
         * hum : 8
         * pcpn : 0.0
         * pop : 1
         * pres : 1013
         * tmp : {"max":"22","min":"8"}
         * vis : 10
         * wind : {"deg":"316","dir":"无持续风向","sc":"微风","spd":"3"}
         */

        @SerializedName("daily_forecast")
        public List<DailyForecastBean> dailyForecast;
        /**
         * date : 2016-04-18 22:00
         * hum : 14
         * pop : 0
         * pres : 1016
         * tmp : 18
         * wind : {"deg":"215","dir":"西南风","sc":"微风","spd":"9"}
         */

        @SerializedName("hourly_forecast")
        public List<HourlyForecastBean> hourlyForecast;

        public static class AqiBean {


            @Override
            public String toString() {
                return "AqiBean{" +
                        "city=" + city +
                        '}';
            }

            /**
             * aqi : 59
             * co : 0
             * no2 : 36
             * o3 : 74
             * pm10 : 59
             * pm25 : 39
             * qlty : 良
             * so2 : 2
             */

            @SerializedName("city")
            public CityBean city;

            public static class CityBean {
                @Override
                public String toString() {
                    return "CityBean{" +
                            "aqi='" + aqi + '\'' +
                            ", co='" + co + '\'' +
                            ", no2='" + no2 + '\'' +
                            ", o3='" + o3 + '\'' +
                            ", pm10='" + pm10 + '\'' +
                            ", pm25='" + pm25 + '\'' +
                            ", qlty='" + qlty + '\'' +
                            ", so2='" + so2 + '\'' +
                            '}';
                }

                @SerializedName("aqi")
                public String aqi;
                @SerializedName("co")
                public String co;
                @SerializedName("no2")
                public String no2;
                @SerializedName("o3")
                public String o3;
                @SerializedName("pm10")
                public String pm10;
                @SerializedName("pm25")
                public String pm25;
                @SerializedName("qlty")
                public String qlty;
                @SerializedName("so2")
                public String so2;
            }
        }

        public static class BasicBean {
            @Override
            public String toString() {
                return "BasicBean{" +
                        "city='" + city + '\'' +
                        ", cnty='" + cnty + '\'' +
                        ", id='" + id + '\'' +
                        ", lat='" + lat + '\'' +
                        ", lon='" + lon + '\'' +
                        ", update=" + update +
                        '}';
            }

            @SerializedName("city")
            public String city;
            @SerializedName("cnty")
            public String cnty;
            @SerializedName("id")
            public String id;
            @SerializedName("lat")
            public String lat;
            @SerializedName("lon")
            public String lon;
            /**
             * loc : 2016-04-18 21:01
             * utc : 2016-04-18 13:01
             */

            @SerializedName("update")
            public UpdateBean update;

            public static class UpdateBean {
                @Override
                public String toString() {
                    return "UpdateBean{" +
                            "loc='" + loc + '\'' +
                            ", utc='" + utc + '\'' +
                            '}';
                }

                @SerializedName("loc")
                public String loc;
                @SerializedName("utc")
                public String utc;
            }
        }

        public static class NowBean {
            @Override
            public String toString() {
                return "NowBean{" +
                        "cond=" + cond +
                        ", fl='" + fl + '\'' +
                        ", hum='" + hum + '\'' +
                        ", pcpn='" + pcpn + '\'' +
                        ", pres='" + pres + '\'' +
                        ", tmp='" + tmp + '\'' +
                        ", vis='" + vis + '\'' +
                        ", wind=" + wind +
                        '}';
            }

            /**
             * code : 101
             * txt : 多云
             */

            @SerializedName("cond")
            public CondBean cond;
            @SerializedName("fl")
            public String fl;
            @SerializedName("hum")
            public String hum;
            @SerializedName("pcpn")
            public String pcpn;
            @SerializedName("pres")
            public String pres;
            @SerializedName("tmp")
            public String tmp;
            @SerializedName("vis")
            public String vis;
            /**
             * deg : 170
             * dir : 西南风
             * sc : 3-4
             * spd : 10
             */

            @SerializedName("wind")
            public WindBean wind;

            public static class CondBean {
                @Override
                public String toString() {
                    return "CondBean{" +
                            "code='" + code + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                @SerializedName("code")
                public String code;
                @SerializedName("txt")
                public String txt;
            }

            public static class WindBean {
                @Override
                public String toString() {
                    return "WindBean{" +
                            "deg='" + deg + '\'' +
                            ", dir='" + dir + '\'' +
                            ", sc='" + sc + '\'' +
                            ", spd='" + spd + '\'' +
                            '}';
                }

                @SerializedName("deg")
                public String deg;
                @SerializedName("dir")
                public String dir;
                @SerializedName("sc")
                public String sc;
                @SerializedName("spd")
                public String spd;
            }
        }

        public static class SuggestionBean {
            @Override
            public String toString() {
                return "SuggestionBean{" +
                        "comf=" + comf +
                        ", cw=" + cw +
                        ", drsg=" + drsg +
                        ", flu=" + flu +
                        ", sport=" + sport +
                        ", trav=" + trav +
                        ", uv=" + uv +
                        '}';
            }

            /**
             * brf : 舒适
             * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
             */

            @SerializedName("comf")
            public ComfBean comf;
            /**
             * brf : 不宜
             * txt : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
             */

            @SerializedName("cw")
            public CwBean cw;
            /**
             * brf : 较冷
             * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
             */

            @SerializedName("drsg")
            public DrsgBean drsg;
            /**
             * brf : 易发
             * txt : 相对于今天将会出现大幅度降温，易发生感冒，注意增加衣服，加强自我防护避免感冒。
             */

            @SerializedName("flu")
            public FluBean flu;
            /**
             * brf : 较不宜
             * txt : 有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意保暖并携带雨具。
             */

            @SerializedName("sport")
            public SportBean sport;
            /**
             * brf : 适宜
             * txt : 温度适宜，又有较弱降水和微风作伴，会给您的旅行带来意想不到的景象，适宜旅游，可不要错过机会呦！
             */

            @SerializedName("trav")
            public TravBean trav;
            /**
             * brf : 最弱
             * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
             */

            @SerializedName("uv")
            public UvBean uv;

            public static class ComfBean {
                @Override
                public String toString() {
                    return "ComfBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                @SerializedName("brf")
                public String brf;
                @SerializedName("txt")
                public String txt;
            }

            public static class CwBean {
                @Override
                public String toString() {
                    return "CwBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                @SerializedName("brf")
                public String brf;
                @SerializedName("txt")
                public String txt;
            }

            public static class DrsgBean {
                @SerializedName("brf")
                public String brf;
                @SerializedName("txt")
                public String txt;
            }

            public static class FluBean {
                @Override
                public String toString() {
                    return "FluBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                @SerializedName("brf")
                public String brf;
                @SerializedName("txt")
                public String txt;
            }

            public static class SportBean {
                @Override
                public String toString() {
                    return "SportBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                @SerializedName("brf")
                public String brf;
                @SerializedName("txt")
                public String txt;
            }

            public static class TravBean {
                @Override
                public String toString() {
                    return "TravBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                @SerializedName("brf")
                public String brf;
                @SerializedName("txt")
                public String txt;
            }

            public static class UvBean {
                @Override
                public String toString() {
                    return "UvBean{" +
                            "brf='" + brf + '\'' +
                            ", txt='" + txt + '\'' +
                            '}';
                }

                @SerializedName("brf")
                public String brf;
                @SerializedName("txt")
                public String txt;
            }
        }

        public static class DailyForecastBean {
            @Override
            public String toString() {
                return "DailyForecastBean{" +
                        "astro=" + astro +
                        ", cond=" + cond +
                        ", date='" + date + '\'' +
                        ", hum='" + hum + '\'' +
                        ", pcpn='" + pcpn + '\'' +
                        ", pop='" + pop + '\'' +
                        ", pres='" + pres + '\'' +
                        ", tmp=" + tmp +
                        ", vis='" + vis + '\'' +
                        ", wind=" + wind +
                        '}';
            }

            /**
             * sr : 05:31
             * ss : 18:55
             */

            @SerializedName("astro")
            public AstroBean astro;
            /**
             * code_d : 100
             * code_n : 104
             * txt_d : 晴
             * txt_n : 阴
             */

            @SerializedName("cond")
            public CondBean cond;
            @SerializedName("date")
            public String date;
            @SerializedName("hum")
            public String hum;
            @SerializedName("pcpn")
            public String pcpn;
            @SerializedName("pop")
            public String pop;
            @SerializedName("pres")
            public String pres;
            /**
             * max : 22
             * min : 8
             */

            @SerializedName("tmp")
            public TmpBean tmp;
            @SerializedName("vis")
            public String vis;
            /**
             * deg : 316
             * dir : 无持续风向
             * sc : 微风
             * spd : 3
             */

            @SerializedName("wind")
            public WindBean wind;

            public static class AstroBean {
                @Override
                public String toString() {
                    return "AstroBean{" +
                            "sr='" + sr + '\'' +
                            ", ss='" + ss + '\'' +
                            '}';
                }

                @SerializedName("sr")
                public String sr;
                @SerializedName("ss")
                public String ss;
            }

            public static class CondBean {
                @Override
                public String toString() {
                    return "CondBean{" +
                            "codeD='" + codeD + '\'' +
                            ", codeN='" + codeN + '\'' +
                            ", txtD='" + txtD + '\'' +
                            ", txtN='" + txtN + '\'' +
                            '}';
                }

                @SerializedName("code_d")
                public String codeD;
                @SerializedName("code_n")
                public String codeN;
                @SerializedName("txt_d")
                public String txtD;
                @SerializedName("txt_n")
                public String txtN;
            }

            public static class TmpBean {
                @Override
                public String toString() {
                    return "TmpBean{" +
                            "max='" + max + '\'' +
                            ", min='" + min + '\'' +
                            '}';
                }

                @SerializedName("max")
                public String max;
                @SerializedName("min")
                public String min;
            }

            public static class WindBean {
                @Override
                public String toString() {
                    return "WindBean{" +
                            "deg='" + deg + '\'' +
                            ", dir='" + dir + '\'' +
                            ", sc='" + sc + '\'' +
                            ", spd='" + spd + '\'' +
                            '}';
                }

                @SerializedName("deg")
                public String deg;
                @SerializedName("dir")
                public String dir;
                @SerializedName("sc")
                public String sc;
                @SerializedName("spd")
                public String spd;
            }
        }

        public static class HourlyForecastBean {
            @Override
            public String toString() {
                return "HourlyForecastBean{" +
                        "date='" + date + '\'' +
                        ", hum='" + hum + '\'' +
                        ", pop='" + pop + '\'' +
                        ", pres='" + pres + '\'' +
                        ", tmp='" + tmp + '\'' +
                        ", wind=" + wind +
                        '}';
            }

            @SerializedName("date")
            public String date;
            @SerializedName("hum")
            public String hum;
            @SerializedName("pop")
            public String pop;
            @SerializedName("pres")
            public String pres;
            @SerializedName("tmp")
            public String tmp;
            /**
             * deg : 215
             * dir : 西南风
             * sc : 微风
             * spd : 9
             */

            @SerializedName("wind")
            public WindBean wind;

            public static class WindBean {
                @Override
                public String toString() {
                    return "WindBean{" +
                            "deg='" + deg + '\'' +
                            ", dir='" + dir + '\'' +
                            ", sc='" + sc + '\'' +
                            ", spd='" + spd + '\'' +
                            '}';
                }

                @SerializedName("deg")
                public String deg;
                @SerializedName("dir")
                public String dir;
                @SerializedName("sc")
                public String sc;
                @SerializedName("spd")
                public String spd;
            }
        }
    }
}
