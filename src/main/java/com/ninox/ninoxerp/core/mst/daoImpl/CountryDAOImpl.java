package com.ninox.ninoxerp.core.mst.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ninox.ninoxerp.core.mst.dao.CountryDAO;
import com.ninox.ninoxerp.core.mst.domain.CountryDM;

@Repository
@Transactional
public class CountryDAOImpl implements CountryDAO {

	private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<CountryDM> getCountryList(Long countryId, String countryCode, String countryName, String status) {
		logger.info("Inside getCountryList >  " + countryId + "," + countryCode + ", " + countryName + "," + status);;
		StringBuffer sql = new StringBuffer("select ");
		sql.append("c.countryId as countryId, c.countryName as countryName, c.countryCode as countryCode, ");
		sql.append("c.isdCode as isdCode, c.gmtOffset as gmtOffset, c.countyStatus as countyStatus, ");
		sql.append("c.lastUpdatedDt as lastUpdatedDt, c.lastUpdateBy as lastUpdateBy from CountryDM c where 1=1");
		Query<CountryDM> query = null;
		if (countryId != null) {
			sql.append(" and c.countryId = '" + countryId + "'");
		}

		if (countryCode != "" && countryCode != null) {
			sql.append(" and lower(c.countryCode) like lower('" + countryCode + "%')");
		}
		
		if (countryName != "" && countryName != null) {
			sql.append(" and lower(c.countryName) like lower('" + countryName + "%')");
		}
		
		if (status != null) {
			sql.append(" and c.countyStats = '" + status + "'");
		}
		
		sql.append(" order by c.lastUpdatedDt desc");
		logger.info("Inside getCountryList > Query > " + sql);
		query = sessionFactory.getCurrentSession().createQuery(sql.toString())
				.setResultTransformer(Transformers.aliasToBean(CountryDM.class));
		return query.getResultList();
	}

	public String getISDCodebyCountryId(Long countryId) {
		logger.info("Inside getISDCodebyCountryId " + countryId);
		String sql = "select c.isdCode from CountryDM c where c.countryId=" + countryId;
		logger.info("Inside getISDCodebyCountryId > Query > " + sql);
		return entityManager.createQuery(sql).toString();
	}
}
