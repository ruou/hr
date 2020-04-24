package pojo;
import java.util.Date;
public class Salary {
		private Long id;		//薪金信息编号
	    private String name;	//员工姓名
	    private Double basic;	//基本薪金
	    private Double eat;		//饭补
	    private Double house;	//房补
	    private Date granttime;	// 工资发放时间
	    private Double duty;		//全勤奖
	    private Double scot;		//扣税
	    private Double punishment;//罚款
	    private Double other;	//额外补助
	    private Double totalize;	//总计
	    public Salary(String name, Double basic, Double eat, Double house, Date granttime, Double duty, Double scot, Double punishment, Double other, Double totalize) {
	        this.name = name;
	        this.basic = basic;
	        this.eat = eat;
	        this.house = house;
	        this.granttime = granttime;
	        this.duty = duty;
	        this.scot = scot;
	        this.punishment = punishment;
	        this.other = other;
	        this.totalize = totalize;
	    }

	    /** default constructor */
	    public Salary() {
	    }

	    public Long getId() {
	        return this.id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return this.name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Double getBasic() {
	        return this.basic;
	    }

	    public void setBasic(Double basic) {
	        this.basic = basic;
	    }

	    public Double getEat() {
	        return this.eat;
	    }

	    public void setEat(Double eat) {
	        this.eat = eat;
	    }

	    public Double getHouse() {
	        return this.house;
	    }

	    public void setHouse(Double house) {
	        this.house = house;
	    }
	    public Date getGranttime() {
	        return granttime;
	    }
	    public void setGranttime(Date granttime) {
	        this.granttime = granttime;
	    }
	    public Double getDuty() {
	        return this.duty;
	    }

	    public void setDuty(Double duty) {
	        this.duty = duty;
	    }

	    public Double getScot() {
	        return this.scot;
	    }

	    public void setScot(Double scot) {
	        this.scot = scot;
	    }

	    public Double getPunishment() {
	        return this.punishment;
	    }

	    public void setPunishment(Double punishment) {
	        this.punishment = punishment;
	    }

	    public Double getOther() {
	        return this.other;
	    }

	    public void setOther(Double other) {
	        this.other = other;
	    }

	    public Double getTotalize() {
	        return this.totalize;
	    }

	    public void setTotalize(Double totalize) {
	        this.totalize = totalize;
	    }

	    public String toString() {
	        StringBuffer toStr = new StringBuffer();
	        toStr.append("[Stipend] = [\n");
	        toStr.append("    id = " + this.id + ";\n");
	        toStr.append("    name = " + this.name + ";\n");
	        toStr.append("    basic = " + this.basic + ";\n");
	        toStr.append("    eat = " + this.eat + ";\n");
	        toStr.append("    house = " + this.house + ";\n");
	        toStr.append("    granttime = " + this.granttime + ";\n");
	        toStr.append("    duty = " + this.duty + ";\n");
	        toStr.append("    scot = " + this.scot + ";\n");
	        toStr.append("    punishment = " + this.punishment + ";\n");
	        toStr.append("    other = " + this.other + ";\n");
	        toStr.append("    totalize = " + this.totalize + ";\n");
	        toStr.append("    ];\n");
	        return toStr.toString();
	    }
}
