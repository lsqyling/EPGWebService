package com.baustem.xmlservice.dao.m;

import java.util.List;

import com.baustem.xmlservice.base.m.BaseDaoImpl;
import com.baustem.xmlservice.dao.i.ESDao;
import com.baustem.xmlservice.entity.ES;
import com.baustem.xmlservice.entity.Program;
import com.baustem.xmlservice.entity.Transport;

public class ESDaoImpl extends BaseDaoImpl<ES> implements ESDao {

	@Override
	public void createESTable() {
		String sql = "DROP TABLE IF EXISTS ESList";
		this.createDataTable(sql);
		
		sql = "CREATE TABLE IF NOT EXISTS ESList("
				+ "id VARCHAR(255) PRIMARY KEY NOT NULL,"
				+ "streamType VARCHAR(255),"
				+ "PID INT(11),"
				+ "scrambled VARCHAR(255),"
				+ "languageCode VARCHAR(255)"
				+ ")ENGINE=INNODB DEFAULT CHARSET=utf8";
		this.createDataTable(sql);
		
		
		sql = "DROP TABLE IF EXISTS Transport_ESList";
		this.createDataTable(sql);
		
		sql = "CREATE TABLE IF NOT EXISTS Transport_ESList("
				+ "transport_id VARCHAR(255) NOT NULL,"
				+ "es_id VARCHAR(255) NOT NULL,"
				+ "PRIMARY KEY(transport_id,es_id),"
				+ "FOREIGN KEY (transport_id) REFERENCES Transport(id),"
				+ "FOREIGN KEY (es_id) REFERENCES ESList(id)"
				+ ")ENGINE=INNODB DEFAULT CHARSET=utf8";
		this.createDataTable(sql);
		
		
	}

	@Override
	public void batchInsertESTable(List<Program> programList) {
		int count;
		int pSize = programList.size();
		String sql = "INSERT INTO ESList(id,streamType,PID,scrambled,languageCode) VALUES(?,?,?,?,?)";
		
		Object[][] params = new Object[pSize*2][];
		for (int i = 0,j=0; i < params.length&&j<pSize;j++) {
			Program p = programList.get(j);
			List<ES> esList = p.getTransport().getEsList();
			for (ES es : esList) {
				params[i] = new Object[]{
						es.getId(),
						es.getStreamType(),
						es.getPID(),
						es.getScrambled(),
						es.getLanguageCode()
				};
				i++;		
			}
		}
		
		count = this.batch(sql, params);
		System.out.println("ESList 表更新 "+count+" 条数据");
		
		sql = "INSERT INTO Transport_ESList(transport_id,es_id) VALUES (?,?)";
		params = new Object[pSize*2][];
		
		for (int i = 0,j=0; i < params.length&&j<pSize;j++) {
			Transport t = programList.get(j).getTransport();
			List<ES> esList = t.getEsList();
			for (ES es : esList) {
				params[i] = new Object[]{t.getId(),es.getId()};
				i++;
			}
		}
		
		count = this.batch(sql, params);
		System.out.println("Transport_ESList 表更新 "+count+" 条数据");
	}

}
