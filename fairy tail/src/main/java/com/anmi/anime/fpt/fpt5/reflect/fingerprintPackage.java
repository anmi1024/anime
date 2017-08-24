package com.anmi.anime.fpt.fpt5.reflect;

import com.anmi.anime.define.Length;
import com.anmi.anime.define.LessLength;
import com.anmi.anime.define.Required;

import java.util.List;

/**
 * 捺印指掌纹信息类
 * Created by wangjue on 2017/7/5.
 */
public class fingerprintPackage {

    private peopleMsg peopleMsg_node;
    private fingerprintMsg fingerprintMsg_node;
    private fingers fingers_node;


    /**
     *人员信息
     */
    public class peopleMsg {
        @Required
        @Length(4)
        private String zwbdxtlxms;              //指纹比对系统描述
        @Length(23)
        private String ysxt_asjxgrybh;          //原始系统_案事件相关人员编号
        @Length(23)
        private String jzrybh;                  //警综人员编号
        @Required
        @Length(23)
        private String asjxgrybh;               //案事件相关人员编号
        @Length(23)
        private String zzwkbh;                  //指掌纹卡编号
        @Required
        @Length(2)
        private String bnyzwrylbdm;             //被捺印指纹人员类别代码
        @Required
        @LessLength(50)
        private String xm;                      //姓名
        @LessLength(50)
        private String bmch;                    //别名/绰号
        @Required
        @Length(1)
        private String xbdm;                    //性别代码
        @Required
        @Length(8)
        private String csrq;                    //出生日期
        @Required
        @Length(3)
        private String gjdm;                    //国籍代码
        @Required
        @Length(2)
        private String mzdm;                    //民族代码
        @Required
        @Length(3)
        private String cyzjdm;                  //常用证件代码
        @Required
        @LessLength(30)
        private String zjhm;                    //证件号码
        @Required
        @Length(6)
        private String hjdz_xzqhdm;             //户籍地址_行政区划代码
        @Required
        @LessLength(100)
        private String hjdz_dzmc;               //户籍地址_地址名称
        @Required
        @Length(6)
        private String xzz_xzqhdm;              //现住址_行政区划代码
        @Required
        @LessLength(100)
        private String xzz_dzmc;                //现住址_地址名称
        @Required
        @Length(12)
        private String nydw_gajgjgdm;           //捺印单位_公安机关机构代码
        @Required
        @LessLength(100)
        private String nydw_gajgmc;             //捺印单位_公安机关名称
        @Required
        @LessLength(50)
        private String nyry_xm;                 //捺印人员_姓名
        @Required
        @Length(18)
        private String nyry_gmsfhm;             //捺印人员_公民身份号码
        @LessLength(18)
        private String nyry_lxdh;               //捺印人员_联系电话
        @Required
        @LessLength(22)
        private String nysj;                    //捺印时间
        @LessLength(1024)
        private String bz;                      //备注

        public String getZwbdxtlxms() {
            return zwbdxtlxms;
        }

        public void setZwbdxtlxms(String zwbdxtlxms) {
            this.zwbdxtlxms = zwbdxtlxms;
        }

        public String getYsxt_asjxgrybh() {
            return ysxt_asjxgrybh;
        }

        public void setYsxt_asjxgrybh(String ysxt_asjxgrybh) {
            this.ysxt_asjxgrybh = ysxt_asjxgrybh;
        }

        public String getJzrybh() {
            return jzrybh;
        }

        public void setJzrybh(String jzrybh) {
            this.jzrybh = jzrybh;
        }

        public String getAsjxgrybh() {
            return asjxgrybh;
        }

        public void setAsjxgrybh(String asjxgrybh) {
            this.asjxgrybh = asjxgrybh;
        }

        public String getZzwkbh() {
            return zzwkbh;
        }

        public void setZzwkbh(String zzwkbh) {
            this.zzwkbh = zzwkbh;
        }

        public String getBnyzwrylbdm() {
            return bnyzwrylbdm;
        }

        public void setBnyzwrylbdm(String bnyzwrylbdm) {
            this.bnyzwrylbdm = bnyzwrylbdm;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getBmch() {
            return bmch;
        }

        public void setBmch(String bmch) {
            this.bmch = bmch;
        }

        public String getXbdm() {
            return xbdm;
        }

        public void setXbdm(String xbdm) {
            this.xbdm = xbdm;
        }

        public String getCsrq() {
            return csrq;
        }

        public void setCsrq(String csrq) {
            this.csrq = csrq;
        }

        public String getGjdm() {
            return gjdm;
        }

        public void setGjdm(String gjdm) {
            this.gjdm = gjdm;
        }

        public String getMzdm() {
            return mzdm;
        }

        public void setMzdm(String mzdm) {
            this.mzdm = mzdm;
        }

        public String getCyzjdm() {
            return cyzjdm;
        }

        public void setCyzjdm(String cyzjdm) {
            this.cyzjdm = cyzjdm;
        }

        public String getZjhm() {
            return zjhm;
        }

        public void setZjhm(String zjhm) {
            this.zjhm = zjhm;
        }

        public String getHjdz_xzqhdm() {
            return hjdz_xzqhdm;
        }

        public void setHjdz_xzqhdm(String hjdz_xzqhdm) {
            this.hjdz_xzqhdm = hjdz_xzqhdm;
        }

        public String getHjdz_dzmc() {
            return hjdz_dzmc;
        }

        public void setHjdz_dzmc(String hjdz_dzmc) {
            this.hjdz_dzmc = hjdz_dzmc;
        }

        public String getXzz_xzqhdm() {
            return xzz_xzqhdm;
        }

        public void setXzz_xzqhdm(String xzz_xzqhdm) {
            this.xzz_xzqhdm = xzz_xzqhdm;
        }

        public String getXzz_dzmc() {
            return xzz_dzmc;
        }

        public void setXzz_dzmc(String xzz_dzmc) {
            this.xzz_dzmc = xzz_dzmc;
        }

        public String getNydw_gajgjgdm() {
            return nydw_gajgjgdm;
        }

        public void setNydw_gajgjgdm(String nydw_gajgjgdm) {
            this.nydw_gajgjgdm = nydw_gajgjgdm;
        }

        public String getNydw_gajgmc() {
            return nydw_gajgmc;
        }

        public void setNydw_gajgmc(String nydw_gajgmc) {
            this.nydw_gajgmc = nydw_gajgmc;
        }

        public String getNyry_xm() {
            return nyry_xm;
        }

        public void setNyry_xm(String nyry_xm) {
            this.nyry_xm = nyry_xm;
        }

        public String getNyry_gmsfhm() {
            return nyry_gmsfhm;
        }

        public void setNyry_gmsfhm(String nyry_gmsfhm) {
            this.nyry_gmsfhm = nyry_gmsfhm;
        }

        public String getNyry_lxdh() {
            return nyry_lxdh;
        }

        public void setNyry_lxdh(String nyry_lxdh) {
            this.nyry_lxdh = nyry_lxdh;
        }

        public String getNysj() {
            return nysj;
        }

        public void setNysj(String nysj) {
            this.nysj = nysj;
        }

        public String getBz() {
            return bz;
        }

        public void setBz(String bz) {
            this.bz = bz;
        }
    }

    /**
     * 捺印信息
     */
    public class fingerprintMsg {
        @Required
        private int zw_sl;                      //指纹_数量 包括滚动、平面指纹
        @Required
        private int zhw_sl;                     //掌纹_数量 包括平面掌纹、侧掌纹
        @Required
        private int slz_sl;                     //四连指_数量
        @Required
        private int zjw_sl;                     //指节纹_数量
        @Required
        private int qz_sl;                      //全掌_数量

        public int getZw_sl() {
            return zw_sl;
        }

        public void setZw_sl(int zw_sl) {
            this.zw_sl = zw_sl;
        }

        public int getZhw_sl() {
            return zhw_sl;
        }

        public void setZhw_sl(int zhw_sl) {
            this.zhw_sl = zhw_sl;
        }

        public int getSlz_sl() {
            return slz_sl;
        }

        public void setSlz_sl(int slz_sl) {
            this.slz_sl = slz_sl;
        }

        public int getZjw_sl() {
            return zjw_sl;
        }

        public void setZjw_sl(int zjw_sl) {
            this.zjw_sl = zjw_sl;
        }

        public int getQz_sl() {
            return qz_sl;
        }

        public void setQz_sl(int qz_sl) {
            this.qz_sl = qz_sl;
        }
    }

    /**
     * 指纹信息
     */
    public class fingers {
        private List<planar> planars;
        private List<rolling> rollings;

        public List<planar> getPlanars() {
            return planars;
        }

        public void setPlanars(List<planar> planars) {
            this.planars = planars;
        }

        public List<rolling> getRollings() {
            return rollings;
        }

        public void setRollings(List<rolling> rollings) {
            this.rollings = rollings;
        }
    }

    /**
     * 平面指纹
     */
    public class planar extends fingerMsg{

    }
    /**
     * 滚动指纹
     */
    public class rolling extends fingerMsg{

    }
    /**
     *单枚指纹信息
     */
    public class fingerMsg {
        @Length(2)
        private String zwzwdm;                  //指纹指位代码 如果指纹_数量不为零，则必填
        @Length(1)
        private String zzwtztqfsdm;             //指掌纹特征提取方式代码 如果指纹_数量不为零，则必填
        @Length(1)
        private String qzyydm;                  //缺指原因代码 如果指纹_数量不为零，则必填
        @Length(1)
        private String zwwxzfl_zwwxdm;          //指纹纹型主分类_指纹纹型代码 如果指纹_数量不为零，则必填
        @Length(1)
        private String zwwxffl_zwwxdm;          //指纹纹型副分类_指纹纹型代码 如果指纹_数量不为零，则必填
        @Length(5)
        private String zwfxms;                  //指纹方向描述
        @Length(14)
        private String zwzxd;                   //指纹中心点
        @Length(14)
        private String zwfzx;                   //指纹副中心
        @Length(14)
        private String zwzsj;                   //指纹左三角
        @Length(14)
        private String zwysj;                   //指纹右三角
        @LessLength(15)
        private int zwtzd_sl;                   //指纹特征点_数量
        @LessLength(1800)
        private String zwtzdxx;                 //指纹特征点信息
        private byte[] zw_zdyxx;                //指纹_自定义信息
        @LessLength(6)
        private int zw_txspfxcd;                //指纹_图像水平方向长度
        @LessLength(6)
        private int zw_txczfxcd;                //指纹_图像垂直方向长度
        @LessLength(6)
        private int zw_txfbl;                   //指纹_图像分辨率
        @Length(4)
        private String zw_txysffms;             //指纹_图像压缩方法描述  0000表示无压缩，其他值前2个字节数字代表压缩方法代码，后2个字节数字代表系统生产厂商代码
        private byte[] zw_txsj;                 //指纹_图像数据

        public String getZwzwdm() {
            return zwzwdm;
        }

        public void setZwzwdm(String zwzwdm) {
            this.zwzwdm = zwzwdm;
        }

        public String getZzwtztqfsdm() {
            return zzwtztqfsdm;
        }

        public void setZzwtztqfsdm(String zzwtztqfsdm) {
            this.zzwtztqfsdm = zzwtztqfsdm;
        }

        public String getQzyydm() {
            return qzyydm;
        }

        public void setQzyydm(String qzyydm) {
            this.qzyydm = qzyydm;
        }

        public String getZwwxzfl_zwwxdm() {
            return zwwxzfl_zwwxdm;
        }

        public void setZwwxzfl_zwwxdm(String zwwxzfl_zwwxdm) {
            this.zwwxzfl_zwwxdm = zwwxzfl_zwwxdm;
        }

        public String getZwwxffl_zwwxdm() {
            return zwwxffl_zwwxdm;
        }

        public void setZwwxffl_zwwxdm(String zwwxffl_zwwxdm) {
            this.zwwxffl_zwwxdm = zwwxffl_zwwxdm;
        }

        public String getZwfxms() {
            return zwfxms;
        }

        public void setZwfxms(String zwfxms) {
            this.zwfxms = zwfxms;
        }

        public String getZwzxd() {
            return zwzxd;
        }

        public void setZwzxd(String zwzxd) {
            this.zwzxd = zwzxd;
        }

        public String getZwfzx() {
            return zwfzx;
        }

        public void setZwfzx(String zwfzx) {
            this.zwfzx = zwfzx;
        }

        public String getZwzsj() {
            return zwzsj;
        }

        public void setZwzsj(String zwzsj) {
            this.zwzsj = zwzsj;
        }

        public String getZwysj() {
            return zwysj;
        }

        public void setZwysj(String zwysj) {
            this.zwysj = zwysj;
        }

        public int getZwtzd_sl() {
            return zwtzd_sl;
        }

        public void setZwtzd_sl(int zwtzd_sl) {
            this.zwtzd_sl = zwtzd_sl;
        }

        public String getZwtzdxx() {
            return zwtzdxx;
        }

        public void setZwtzdxx(String zwtzdxx) {
            this.zwtzdxx = zwtzdxx;
        }

        public byte[] getZw_zdyxx() {
            return zw_zdyxx;
        }

        public void setZw_zdyxx(byte[] zw_zdyxx) {
            this.zw_zdyxx = zw_zdyxx;
        }

        public int getZw_txspfxcd() {
            return zw_txspfxcd;
        }

        public void setZw_txspfxcd(int zw_txspfxcd) {
            this.zw_txspfxcd = zw_txspfxcd;
        }

        public int getZw_txczfxcd() {
            return zw_txczfxcd;
        }

        public void setZw_txczfxcd(int zw_txczfxcd) {
            this.zw_txczfxcd = zw_txczfxcd;
        }

        public int getZw_txfbl() {
            return zw_txfbl;
        }

        public void setZw_txfbl(int zw_txfbl) {
            this.zw_txfbl = zw_txfbl;
        }

        public String getZw_txysffms() {
            return zw_txysffms;
        }

        public void setZw_txysffms(String zw_txysffms) {
            this.zw_txysffms = zw_txysffms;
        }

        public byte[] getZw_txsj() {
            return zw_txsj;
        }

        public void setZw_txsj(byte[] zw_txsj) {
            this.zw_txsj = zw_txsj;
        }
    }

    /**
     * 掌纹信息
     */
    public class palms {

    }

    /**
     * 四连指信息
     */
    public class fourprints {

    }

    /**
     * 指节纹信息
     */
    public class knuckleprints {

    }

    /**
     * 全掌信息
     */
    public class fullpalms {

    }
}
