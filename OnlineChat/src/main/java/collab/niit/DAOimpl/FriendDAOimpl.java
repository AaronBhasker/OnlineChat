package collab.niit.DAOimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collab.niit.DAO.FriendDAO;

import collab.niit.model.Friend;
import collab.niit.model.Jobs;
import collab.niit.model.User;
@Repository("friendDAO")
@Transactional
public class FriendDAOimpl implements FriendDAO{

	@Autowired
	SessionFactory sessionFactory;
		public boolean addFriend(Friend friend) {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		
		public boolean acceptRequest(Friend friend) {
			friend.setStatus('A');
			sessionFactory.getCurrentSession().update(friend);
			
			return false;
		}

		
		

		@Override
		public List<Friend> pendingRequests(char status,String email) {
			
			List<Friend> Friends=sessionFactory.getCurrentSession().createQuery("from Friend where status='"+status+"' and toId.emailId='"+email+"'").list();
			
			return Friends;
			
			
		}

		@Override
		public List<User> getallUsers(String email) {
			String q="select * from userdetails where emailId in(select emailId from userdetails where emailId!=:email minus"
					+ "(select toId_emailId from Friend where fromId_emailId=:fromemail "
					+ "union select fromId_emailId from Friend where toId_emailId=:toemail))";
			
			SQLQuery sqlq=sessionFactory.getCurrentSession().createSQLQuery(q);
			sqlq.setParameter("email",email);
			sqlq.setParameter("fromemail",email);
			sqlq.setParameter("toemail", email);
			List<User> allUsers=sqlq.list();
			return allUsers;
		}

		@Override
		public List<Friend> Friends(String email) {
			
			Query q1=sessionFactory.getCurrentSession().createQuery("select f.fromId from Friend f where f.status='A' and f.toId.emailId=?");
			q1.setString(0, email);
			List<Friend> list1=q1.list();
			Query q2=sessionFactory.getCurrentSession().createQuery("select f.toId from Friend f where f.status='A' and f.fromId.emailId=?");
			q2.setString(0,email);
			List<Friend> list2=q2.list();
			list1.addAll(list2);
			return list1;
		}

		@Override
		public boolean rejectRequest(Friend friend) {
			sessionFactory.getCurrentSession().delete(friend);
			
			return false;
		}
		

		
}
