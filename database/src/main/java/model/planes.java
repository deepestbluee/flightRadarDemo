package model;


import java.util.List;
public class planes {

	
	

    private Integer planeid;
	private List<Double> coords;
	
	   public Integer getPlaneid() {
			return planeid;
		}
		public void setPlaneid(Integer planeid) {
			this.planeid = planeid;
		}
		public List<Double> getCoords() {
			return coords;
		}
		public void setCoords(List<Double> coords) {
			this.coords = coords;
		}
		public planes(Integer planeid, List<Double> coords) {
			this.planeid = planeid;
			this.coords = coords;
		}
		
		public planes() {
		}
	
}
