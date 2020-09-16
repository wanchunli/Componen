package com.anso.componen.constants;
//*******************************************************
//* 项目名称：as-outwork-platform
//* 创建者： Mr.Fang
//* 创建日期： 2018/4/12 9:45
//* 描述：SharedPreferences常量
//*******************************************************

public class SPConstans {

    //保存在手机里面的文件名
    public static final String SHARED_NAME = "anso_sp";
    public static final String FUN_IS_INIT = "fun_is_init";
    //*******************************************************

    public static final String SETTING_ISSHOW_VOICE="setting_isshow_voice";//是否开启语音提醒
    public static final String SETTING_ISRIGHT_HAND="setting_isright_hand";//是否是右手键盘
    public static final String SETTING_ISNINE_KEYBORE="setting_isnine_keybore";//是否是九宫格键盘
    public static final String SETTING_ISSUPPORT_CONTONESE="setting_issupport_contonese";//是否支持粤语
    public static final String SETTING_ISMANDARIN_LANGUAGE="setting_ismandarin_language";//是否是非普通话
    public static final String SETTING_LANGUAGE="setting_language";//语言
    public static final String SETTING_ISSHOW_FLASH="setting_isshow_flash";//是否开启摇一摇打开手电筒
    public static final String IS_FINISH_FACE_RECOGNITION="is_finish_face_recognition";//是否进行了人脸识别
    public static final String IS_FIRST_VOICE="is_first_voice";//是否拷贝文件完成
    public static final String IS_OUT_METERREADING="is_out_meterreading";//是否从抄表模块退出
    public static final String IGNO_UP_TIMES_HOST="igno_up_times_host";//忽略宿主更新时间
    public static final String SETTING_ISSHOW_SUBNITBOOK="setting_isshow_subnitbook";//是否隐藏已提交册本
    public static final String IGNO_UP_HOST_VER="igno_up_host_ver";//忽略宿主版本

    public static final String IGNO_UP_TIMES_PLUGIN="igno_up_times_plugin";//忽略宿主更新时间
    public static final String IGNO_UP_PLUGIN_VER="igno_up_plugin_ver";//忽略宿主版本
    //用户名字
    public static final String USER_NAME = "user_name";
    public static final String USER_PASS = "user_pass";

    //登录用户token
    public static final String USER_TOKEN = "token";
    public static final String LOGIN_TYPE = "login_type";
    public static final String USER_BEAN = "user_bean";
    public static final String UMENG_TOKEN = "umeng_token";
    public static final String USER_FACE_PATH = "user_face_path";
    public static final String FACE_ISUPLOAD = "face_isupload";

    public static final String USER_ID="user_id";
    public static final String BOOK_USER_CODE="book_user_code";

    public  static  final String PLUGININFO="plugininfo";//获取插件下载地址

    //权限控制
    public static final String PERMISSION_METERREADING = "permission_meterreading";//是否有抄表的权限
    public static final String PERMISSION_REVIEW = "permission_review";//是否有复核的权限
    public static final String PERMISSION_SCADA = "permission_scada";//是否有SCADA的权限

    //服务器配置参数控制
    public static final String FLAY_POINT_ACCURACY = "flay_point_accuracy";//判断是否为飞点的精度
    public static final String FLAY_POINT_DISTANCE = "flay_point_distance";//判断是否为飞点的距离
    public static final String WALKINGTRACKCOLLECTIONFREQUENCY = "walkingTrackCollectionFrequency";//行走轨迹采集频率
    public static  final String ALLOWVIDEOTIME = "allowVideoTime";//允许视频录制时长
    public static  final String ALLOWUPLOADPICNUM = "allowUploadPicNum";//允许上传图片数量
    public static  final String ALLOWUPLOADVIDEONUM = "allowUploadVideoNum";//允许上传视频数量
    public static  final String AUTOLOGOUTTIME = "autoLogoutTime";//抄表模块自动退出时间
    public static  final String MUSTTAKEPHOTO = "mustTakePhoto";//抄表模块是否必须拍照
    public static final String IS_MAX_MIN_LAYOUT="is_max_min_layout";//精简布局于复杂布局比较
    public static final String IS_SHOW_USERLIST="is_show_userlist";//是否显示用户列表
    public static  final String STAYAREA = "stayArea";//抄表停留点
    public static  final String ESTIMATEREAD = "estimateRead";//故意估抄范围

    public static final String IS_USER_LOCAL_DISTANCE = "is_user_local_distance";//判断是否到位的距离
    public static  final String MOSTRECORDVIDEOTIME = "MostRecordVideoTime";

    public static  final String APP_IP = "app_ip";//app中ip地址
    public static  final String APP_PORT = "app_port";//app中端口

    //定位相关参数
   /* public  static  final  String LOC_LATITUDE="myLatitude";
    public  static  final  String LOC_LONGITUDE="myLongitude";
    public  static  final  String LOC_LOCATIONTYPE="mLocationType";
    public  static  final  String LOC_MACCURACY="mAccuracy";
    public  static  final  String LOC_ADDR="addr";
    public  static  final  String LOC_SPEED="addr";
    public  static  final  String LOC_ANGLE="angle";*/

    //人脸验证
    public  static  final String FACEVAILD="facevaild";

    public  static  int ssssss=0;


    /**
     * 用户人脸名称
     */
    public static final String USER_FACE_NAME = "user_face_name";

}
