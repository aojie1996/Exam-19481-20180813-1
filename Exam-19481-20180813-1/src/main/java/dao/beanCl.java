package dao;

import impl.ImplDao;
import model.Film;
import util.ConnDB;

import java.sql.*;
import java.util.ArrayList;

public class beanCl implements ImplDao {
    private Connection ct = null;
    private Statement sm = null;
    private ResultSet rs = null;
    private PreparedStatement ps=null;
    @Override
    public boolean checkUser(String username) {
        boolean b = false;
        try {
            ct = new ConnDB().getconn();
            sm = ct.createStatement();
            rs=sm.executeQuery("select count(1) from customer where FIRST_NAME ='"+username+"'");
            if(rs.next()){
                if(rs.getInt(1)==1){
                    b=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.close();
        }
        return b;
    }

    /**
     *
     * @param
     * @return 电影列表的list集合
     */
    @Override
    public ArrayList<Object> getFilms() {
        ArrayList<Object> a1 = new ArrayList<Object>();
        try {
            ct =new ConnDB().getconn();
            sm =ct.createStatement();
            rs=sm.executeQuery("select f.film_id,f.title,f.description,l.name " +
                    "from film f,language l where f.language_id=l.language_id order by f.film_id");
            while(rs.next()){
                Film film = new Film();
                film.setFilm_id(rs.getInt(1));
                film.setTitle(rs.getString(2));
                film.setDescription(rs.getString(3));
                film.setLanguageName(rs.getString(4));
                a1.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.close();
        }
        return a1;
    }

    @Override
    public boolean deleteFilm(String film_id) {
        boolean b =false;
        try {
            ct = new ConnDB().getconn();
            sm =ct.createStatement();
            int a1=sm.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            if (a1==0){
                int a=sm.executeUpdate("delete from film where film_id='"+film_id+"'");
                if (a==1){
                    b=true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.close();
        }
        return b;
    }

    /**
     * 修改电影信息的方法
     * @param filmId
     * @param filmTitle
     * @param filmdescription
     * @param filmLanguageId
     * @return
     */
    @Override
    public boolean updateFilm(String filmId, String filmTitle, String filmdescription, String filmLanguageId) {
        boolean b =false;
        try {
            ct =new ConnDB().getconn();
            ps=ct.prepareStatement("update film set title=?,description=?,language_id=? where film_id=?");
            ps.setString(1,filmTitle);
            ps.setString(2,filmdescription);
            ps.setString(3,filmLanguageId);
            ps.setString(4,filmId);
            System.out.println("------------------------执行到这了---------------------------------");
            int a =ps.executeUpdate();
            if(a==1){
                b=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.close();
        }
        return b;
    }

    @Override
    public boolean addFilm(String filmId, String filmTitle, String filmdescription, String filmLanguageId) {
        boolean b =false;
        try {
            ct =new ConnDB().getconn();
            ps=ct.prepareStatement("insert into film(film_id,title,description,language_id) values(?,?,?,?)");
            ps.setString(1, filmId);
            ps.setString(2, filmTitle);
            ps.setString(3, filmdescription);
            ps.setString(4, filmLanguageId);
            int a = ps.executeUpdate();
            if(a==1){
                b=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.close();
        }
        return b;
    }

    //关闭的方法
    public void close() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (sm != null) {
                sm.close();
                sm = null;
            }
            if (ct != null) {
                ct.close();
                ct = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
