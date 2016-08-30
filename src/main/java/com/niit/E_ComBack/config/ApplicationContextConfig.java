package com.niit.E_ComBack.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.niit.E_ComBack.dao.CategoryDAO;
import com.niit.E_ComBack.dao.CategoryDAOImpl;
import com.niit.E_ComBack.dao.ProductDAO;
import com.niit.E_ComBack.dao.ProductDAOImpl;
import com.niit.E_ComBack.dao.SupplierDAO;
import com.niit.E_ComBack.dao.SupplierDAOImpl;
import com.niit.E_ComBack.dao.UserDAO;
import com.niit.E_ComBack.dao.UserDAOImpl;
import com.niit.E_ComBack.model.Category;
import com.niit.E_ComBack.model.Product;
import com.niit.E_ComBack.model.Supplier;
import com.niit.E_ComBack.model.UserDetails;

@Configuration
@ComponentScan(basePackages={"com.niit.E_ComBack.dao"})
@EnableWebMvc
@EnableTransactionManagement
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {
	
	@Bean(name ="dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/E-ComDB");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	
	@Autowired
	@Bean(name ="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		/*sessionBuilder.addAnnotatedClasses(Cart.class);*/

		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
//	@Autowired
//	@Bean(name="categoryDao")
//	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
//	{
//		return new CategoryDAOImpl(sessionFactory);
//	}
	

	@Autowired
	@Bean(name="supplierDao")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDAOImpl(sessionFactory);
	}
	

	@Autowired
	@Bean(name="productDao")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDao")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		return new UserDAOImpl(sessionFactory);
		
	}

}
