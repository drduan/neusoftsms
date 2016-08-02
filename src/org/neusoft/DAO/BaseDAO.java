package org.neusoft.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.neusoft.interfaces.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.sun.xml.internal.bind.v2.TODO;
@Transactional //声明该方法需要事务处理
public class BaseDAO<T> extends HibernateTemplate implements DAO {
	public static final int INSERT=1;
	public static final int DELETE=2;
	public static final int UPDATE=3;
	private Class type;

	@Autowired
	public BaseDAO(SessionFactory sessionFactory) {
		super(sessionFactory);

		ParameterizedType parameterizedType = (ParameterizedType) this
				.getClass().getGenericSuperclass();
		this.type = (Class) parameterizedType.getActualTypeArguments()[0];
	    //entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}
	


	@Override
	public List getAll() {

		return find(new StringBuffer(" from ").append(this.type.getName())
				.toString());
	}

	@Override
	public Object getByID(Serializable id) {

		return get(this.type.getName(), id);
	}

	@Override
	//实体criterion
	public List getInfosByProperties(Criterion... criterions) {

		return getInfosByProperties(null, null, criterions);
	}

	@Override
	public List getInfosByProperties(Integer pageNum, Integer rowCount,
			Criterion... criterions) {

		DetachedCriteria criteria = DetachedCriteria.forClass(type);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		if (pageNum != null && rowCount != null && pageNum >= 1
				&& rowCount >= 1) {
			return findByCriteria(criteria, (pageNum - 1) * rowCount, rowCount);
		}
		return findByCriteria(criteria);
	}

	
//todo 
	void update(int wtd, Object... ts) {
		int i=0;
		switch (wtd) {
		case INSERT:
			for (Object object : ts) {
				if(++i%50==0){
					this.flush();
					this.clear();
				}
				save(object);
			}
			break;
		case DELETE:
			for (Object object : ts) {
				if(++i%50==0){
					this.flush();
					this.clear();
				}
				delete(object);
			}
			break;
		case UPDATE:
			for (Object object : ts) {
				if(++i%50==0){
					this.flush();
					this.clear();
				}
				update(object);
			}
			break;
		}
	}

	@Override
	public void excute_insert(Object... ts) {

		this.update(INSERT,ts);
	}

	@Override
	public void excute_delete(Object... ts) {

		this.update(DELETE,ts);

	}

	@Override
	public void excute_update(Object... ts) {

		this.update(UPDATE,ts);
	}

	@Override
	public int getPageCountByRowCount(int rowCount) {
		//setMaxResult(int maxResults):设定一次最多检索出的对象的数目，
		// query.setFirstResult(2);//显示第几页，当前页
		Session session= this.getSessionFactory().getCurrentSession();
		Query query=session.createQuery("select count(v1) from "+this.type.getSimpleName()+" v1 ");
		System.out.println("baseDao"+query.toString());
		
		long count = (long) query.uniqueResult();
		return (int) (count%rowCount==0?count/rowCount:(count/rowCount)+1);
	}

}
