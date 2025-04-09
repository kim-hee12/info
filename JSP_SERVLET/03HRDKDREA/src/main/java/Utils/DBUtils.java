package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	//싱글톤 
	private static DBUtils instance;
	private DBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static DBUtils getInstance() throws Exception {
		if(instance==null)
			instance = new DBUtils();
		return instance;
	}
	
	// 강사테이블 조회
	public List<TeacherDto> selectAllTeacher() throws Exception{
		String sql="select*from TBL_TEACHER_202201";
		pstmt = conn.prepareStatement(sql);
		
		rs= pstmt.executeQuery();
		List<TeacherDto> list = new ArrayList();
		TeacherDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new TeacherDto();
				dto.setTeacher_code(rs.getString(1));
				dto.setTeacher_name(rs.getString(2));
				dto.setClass_name(rs.getString(3));
				dto.setClass_price(rs.getInt(4));
				dto.setTeacher_regist_date(rs.getString(5));
				list.add(dto);
			}
		}
		return list;
	}
	
	public List<MemberDto> selectAllMember() throws Exception{
		
		String sql="select*from TBL_MEMBER_202201";
		pstmt = conn.prepareStatement(sql);
		
		rs= pstmt.executeQuery();
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new MemberDto();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setGrade(rs.getString(5));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<ClassDto> selectAllClass() throws Exception{
		String sql="select*from TBL_CLASS_202201";
		pstmt = conn.prepareStatement(sql);
		
		rs= pstmt.executeQuery();
		List<ClassDto> list = new ArrayList();
		ClassDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new ClassDto();
				dto.setRegist_month(rs.getString(1));
				dto.setC_no(rs.getString(2));
				dto.setClass_area(rs.getString(3));
				dto.setTuition(rs.getString(4));
				dto.setTeacher_code(rs.getString(5));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public int insertClass(ClassDto classDto) throws Exception {
		pstmt = conn.prepareStatement("insert into TBL_CLASS_202201 values(?,?,?,?,?)");
		pstmt.setString(1, classDto.getRegist_month());
		pstmt.setString(2, classDto.getC_no());
		pstmt.setString(3, classDto.getClass_area());
		pstmt.setString(4, classDto.getTuition());
		pstmt.setString(5, classDto.getTeacher_code());
		
		int result = pstmt.executeUpdate();
		
		conn.commit();
		pstmt.close();
		return result;
	}
	
	public List<JoinDto> selectAllJoin() throws Exception{
		String sql="SELECT C.REGIST_MONTH,M.C_NO,M.C_NAME,T.CLASS_NAME,C.CLASS_AREA,C.TUITION,M.GRADE"
				+ " FROM TBL_MEMBER_202201 M"
				+ " JOIN TBL_CLASS_202201 C"
				+ " ON C.C_NO=M.C_NO"
				+ " JOIN TBL_TEACHER_202201 T"
				+ " ON C.TEACHER_CODE=T.TEACHER_CODE";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		List<JoinDto> list = new ArrayList();
		JoinDto dto = null;
		if(rs!=null) {
			
			while(rs.next()) {

				dto=new JoinDto();
				dto.setRegist_month(rs.getString(1));
				dto.setC_no(rs.getString(2));
				dto.setC_name(rs.getString(3));
				dto.setClass_name(rs.getString(4));
				dto.setClass_area(rs.getString(5));
				dto.setTuition(rs.getString(6));
				dto.setGrade(rs.getString(7));
				list.add(dto);
			}
			
		}
		rs.close();
		pstmt.close();
		return list;
	}
	public List<Join2Dto> selectAllJoin2() throws Exception{
		String sql="select t.teacher_code,t.class_name,t.teacher_name,sum(c.tuition)"
				+ " from tbl_class_202201 c"
				+ " join tbl_teacher_202201 t"
				+ " on c.teacher_code = t.teacher_code"
				+ " group by t.teacher_code,t.class_name,t.teacher_name"
				+ " order by sum(c.tuition) desc";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		List<Join2Dto> list = new ArrayList();
		Join2Dto dto = null;
		if(rs!=null) {
			
			while(rs.next()) {
				
				dto=new Join2Dto();
				dto.setTeacher_code(rs.getString(1));
				dto.setClass_name(rs.getString(2));
				dto.setTeacher_name(rs.getString(3));
				dto.setTotal_tuition(rs.getString(4));
				list.add(dto);
			}
			
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
}
