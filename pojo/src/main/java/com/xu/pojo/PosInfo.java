package com.xu.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PosInfo {

	private double lat;// 纬度
	
	private double lon; // 经度
	
	private short alt; // 高度
	
	private Timestamp posTime; // 时间
	
	private byte acc; // acc状态
	
	private byte alarm; // 1,点火; 2,熄火
	
	private short speed; // GPS瞬时速度(km/h) 超速报警用到
	
}
