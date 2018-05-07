package com.hngy.rjxh.artifactforcar.model;

public class SensorDataBean {
    /***
     * 血脂四项的具体包括总胆固醇(TCHO)、甘油三脂(TG)、高密度脂蛋白(HDL-C)和低密度脂蛋白(LDL-G)。
     * 由于血脂浓度与心脑血管疾病关系密切，所以这项检查有助于诊断动脉硬化症，冠心病及肾病综合症的诊断。
     * 总胆固醇(TCHO) 升高见于：甲状腺功能减退、高脂血症、动脉粥样硬化、肾病综合征、肝细胞性黄疸、阻塞性黄疸及重症糖尿病等;
     * 降低见于：严重的肝脏疾病患者，如急性肝坏死或肝硬化;恶性贫血、溶血性贫血、甲状腺机能亢进、急性感染、营养不良等;
     * 甘油三脂(TG) 升高见于：糖尿病、糖原累积症、甲状腺功能不足、肾病综合征、妊娠、急性胰岛炎高危状态时;
     * 减低见于：甲状腺功能亢进，肾上腺皮质机能减退，肝功能严重低下;
     * 高密度脂蛋白(HDL-C) 升高见于：糖尿病、糖原累积症、甲状腺功能不足、肾病综合征、妊娠、急性胰岛炎高危状态时;
     * 减低见于：甲状腺功能亢进，肾上腺皮质机能减退，肝功能严重低下;
     * 低密度脂蛋白(LDL-G) 增高：家族性2型高脂蛋白血症、肾病综合症、肝病;
     * 降低：肝功异常、遗传性无B脂蛋白血症;
     */
    double vTemperature; //T 体温
    double vWeight; //BW 体重
    double vHeart_rate; //P 心率
    double vBP_diastolic; //BPD 舒张压 mmHg
    double vBP_systolic; //BPS 收缩压 mmHg
    double vBF_TCHO; //BFTC 总胆固醇 mmol/L
    double vBF_TG; //BFTG 甘油三脂 mmol/L
    double vBF_HDL_C; //BFHD 高密度脂蛋白 mmol/L
    double vBF_LDL_G; //BFLD 低密度脂蛋白 mmol/L

    public SensorDataBean(double vTemperature, double vWeight, double vHeart_rate, double vBP_diastolic, double vBP_systolic, double vBF_TCHO, double vBF_TG, double vBF_HDL_C, double vBF_LDL_G) {
        this.vTemperature = vTemperature;
        this.vWeight = vWeight;
        this.vHeart_rate = vHeart_rate;
        this.vBP_diastolic = vBP_diastolic;
        this.vBP_systolic = vBP_systolic;
        this.vBF_TCHO = vBF_TCHO;
        this.vBF_TG = vBF_TG;
        this.vBF_HDL_C = vBF_HDL_C;
        this.vBF_LDL_G = vBF_LDL_G;
    }

    /***
     * 根据TAG和数字设置各项传感器的值
     * @param TAG 标签
     * @param value 值
     */
    public void setValue(String TAG,double value){
        switch (TAG){
            case "T": this.vTemperature = value; break;
            case "BW": this.vWeight = value; break;
            case "P": this.vHeart_rate = value; break;
            case "BPD": this.vBP_diastolic = value; break;
            case "BPS": this.vBP_systolic = value; break;
            case "BFTC": this.vBF_TCHO = value; break;
            case "BFTG": this.vBF_TG = value; break;
            case "BFHD": this.vBF_HDL_C = value; break;
            case "BFLD": this.vBF_LDL_G = value; break;
            default: break;
        }
    }

    /***
     * 根据TAG获取各项传感器的值和单位以及对应的名称
     * @param TAG 标签
     */
    public String getData(String TAG){
        switch (TAG){
            case "T": return vTemperature+" ℃";
            case "BW": return vWeight+" kg";
            case "P": return vHeart_rate+" 次/分钟";
            case "BP": return vBP_systolic+"mmHg/"+vBP_diastolic+"mmHg";
            case "BFTC": return vBF_TCHO+" mmol/L";
            case "BFTG": return vBF_TG+" mmol/L";
            case "BFHD": return vBF_HDL_C+" mmol/L";
            case "BFLD": return vBF_LDL_G+" mmol/L";
            default: return "";
        }
    }

    /***
     * 根据TAG获取各项传感器的值
     * @param TAG 标签
     */
    public double getValue(String TAG){
        switch (TAG){
            case "T": return vTemperature;
            case "BW": return vWeight;
            case "P": return vHeart_rate;
            case "BPS": return vBP_systolic;
            case "BPD": return vBP_diastolic;
            case "BFTC": return vBF_TCHO;
            case "BFTG": return vBF_TG;
            case "BFHD": return vBF_HDL_C;
            case "BFLD": return vBF_LDL_G;
            default: return 0;
        }
    }

}
