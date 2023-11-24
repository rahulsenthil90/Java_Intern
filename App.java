import java.sql.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            boolean f,f1,f2,f3,f4,check,check1;
            System.out.println("\n\t\t\t>>>>> Welcome to CodSoft Institute <<<<<");
            f=true;
            while(f){
                System.out.println("\n1.Admin\n2.Student\n3.Exit");
                int choice=sc.nextInt();
                if(choice==1){
                    System.out.print("\t\t\t>>> Admin Login <<<\nAdmin ID: ");
                    int admin_id=sc.nextInt();
                    System.out.print("\nEnter Passkey: ");
                    int pass_key=sc.nextInt();
                    if(admin_id==2304 && pass_key==3012){
                        f1=true;
                        while(f1){
                        System.out.println("\n1.Add Course\n2.Add Student\n3.Update Course\n4.Update Student\n5.View Courses\n6.View Student\n7.exit");
                        int achoice=sc.nextInt();
                        f2=true;
                        while(f2){
                            if(achoice==1){
                                System.out.print("Course Code: ");
                                int course_code=Integer.parseInt(sc.next());
                                sc.nextLine();
                                System.out.print("Course Title: ");
                                String course_title=sc.nextLine();
                                System.out.print("Course Descritpion: ");
                                String course_description=sc.nextLine();
                                System.out.print("Course Capacity: ");
                                int course_capacity=sc.nextInt();
                                System.out.print("Course Schedule: ");
                                String course_schedule=sc.next();
                                try{  
                                    Class.forName("com.mysql.cj.jdbc.Driver");  
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                    String sql="insert into course values(?,?,?,?,?)";
                                    PreparedStatement ps=con.prepareStatement(sql);
                                    ps.setInt(1, course_code);
                                    ps.setString(2, course_title);
                                    ps.setString(3, course_description);
                                    ps.setInt(4, course_capacity);
                                    ps.setString(5, course_schedule);
                                    ps.executeUpdate();
                                    con.close(); 
                                    System.out.println("\nCourse Saved Successfully\n"); 
                                    }
                                catch(Exception e){ 
                                    System.out.println(e);
                                }
                                f2=false;
                            }
                            else if(achoice==2){
                                System.out.print("Student ID: ");
                                int stu_id=Integer.parseInt(sc.next());
                                sc.nextLine();
                                System.out.print("Student Name: ");
                                String stu_name=sc.nextLine();
                                System.out.print("Enter DOB (ex:01072000): ");
                                int dob=sc.nextInt();
                                try{  
                                    Class.forName("com.mysql.cj.jdbc.Driver");  
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                    String sql="insert into studentdetail values(?,?,?)";
                                    PreparedStatement ps=con.prepareStatement(sql);
                                    ps.setInt(1, stu_id);
                                    ps.setString(2, stu_name);
                                    ps.setInt(3, dob);
                                    ps.executeUpdate();
                                    con.close();  
                                    System.out.println("\nStudent Saved Successfully\n");
                                    }
                                catch(Exception e){ 
                                    System.out.println(e);
                                }
                                f2=false;
                            }
                            else if(achoice==4){
                                System.out.println("Please choose the one of the following to change:\n1.Student ID\n2.Student Name \n3.DOB\n4.Change All\n5.Exit");
                                int aachoice=sc.nextInt();
                                f3=true;
                                while(f3){
                                    if(aachoice==1){
                                        System.out.print("Please enter the Student ID you want to make change: ");
                                        int stu_id=Integer.parseInt(sc.next());
                                        System.out.print("Student New ID: ");
                                        int stu_id1=Integer.parseInt(sc.next());
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from studentdetail;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkid=rs.getInt(1);
                                                if(checkid==stu_id){
                                                    String sql="update studentdetail set stuID='"+stu_id1+"' where stuID="+stu_id+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo Student available on that ID\n");
                                            }
                                            else{
                                                System.out.println("\nStudent ID Updated Successfully\n");
                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    if(aachoice==2){
                                        System.out.print("Please enter the Student ID you want to make change: ");
                                        int stu_id=Integer.parseInt(sc.next());
                                        System.out.print("Student New Name: ");
                                        String stu_name=sc.nextLine();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from studentdetail;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkid=rs.getInt(1);
                                                if(checkid==stu_id){
                                                    String sql="update studentdetail set stu_name ='"+stu_name+"' where stuID="+stu_id+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo Student available on that ID\n");
                                            }
                                            else{
                                                System.out.println("\nStudent Name Updated Successfully\n");
                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    if(aachoice==3){
                                        System.out.print("Please enter the Student ID you want to make change: ");
                                        int stu_id=Integer.parseInt(sc.next());
                                        System.out.print("Student New DOB: ");
                                        int stu_dob=Integer.parseInt(sc.next());
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from studentdetail;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkid=rs.getInt(1);
                                                if(checkid==stu_id){
                                                    String sql="update studentdetail set dob ='"+stu_dob+"' where stuID="+stu_id+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo Student available on that ID\n");
                                            }
                                            else{
                                                System.out.println("\nStudent DOB Updated Successfully\n");
                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    if(aachoice==4){
                                        System.out.print("Please enter the Student ID you want to make change: ");
                                        int stu_id=Integer.parseInt(sc.next());
                                        System.out.print("Student ID: ");
                                        int stu_id1=Integer.parseInt(sc.next());
                                        sc.nextLine();
                                        System.out.print("Student Name: ");
                                        String stu_name=sc.nextLine();
                                        System.out.print("Enter DOB (ex:01072000): ");
                                        int dob=sc.nextInt();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from studentdetail;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkid=rs.getInt(1);
                                                if(checkid==stu_id){
                                                    String sql="update studentdetail set stuID ='"+stu_id1+"',stu_name ='"+stu_name+"',dob ='"+dob+"' where stuID="+stu_id+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo Student available on that ID\n");
                                            }
                                            else{
                                                System.out.println("\nStudent Updated Successfully\n");
                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    else if(aachoice==5){
                                        f3=false;
                                    }
                                    else{
                                        System.out.println("Please enter a valid number!");
                                    }
                                }
                                f2=false;
                            }
                            else if(achoice==3){
                                System.out.println("Please choose the one of the following to change:\n1.Course Code\n2.Course Title \n3.Course Description\n4.Course Capacity\n5.Course Schedule\n6.Change All\n7.Exit");
                                int aachoice=sc.nextInt();
                                f3=true;
                                while(f3){
                                    if(aachoice==1){
                                        System.out.print("Please enter the Course Code you want to make change: ");
                                        int course_code=Integer.parseInt(sc.next());
                                        System.out.print("Course New Code: ");
                                        int course_code1=Integer.parseInt(sc.next());
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from course;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkcode=rs.getInt(1);
                                                if(checkcode==course_code){
                                                    String sql="update course set code ='"+course_code1+"' where code="+course_code+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo course available on that code\n");
                                            }
                                            else{
                                                System.out.println("\nCourse Registered Successfully\n");
                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    if(aachoice==2){
                                        System.out.print("Please enter the Course Code you want to make change: ");
                                        int course_code=Integer.parseInt(sc.next());
                                        sc.nextLine();
                                        System.out.print("Course New Title: ");
                                        String course_title=sc.nextLine();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from course;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkcode=rs.getInt(1);
                                                if(checkcode==course_code){
                                                    String sql="update course set title='"+course_title+"' where code="+course_code+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo course available on that code\n");
                                            }
                                            else{
                                                System.out.println("\nCourse Registered Successfully\n");
                                            }
                                            
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    if(aachoice==3){
                                        System.out.print("Please enter the Course Code you want to make change: ");
                                        int course_code=Integer.parseInt(sc.next());
                                        sc.nextLine();
                                        System.out.print("Course Descritpion: ");
                                        String course_description=sc.nextLine();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from course;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkcode=rs.getInt(1);
                                                if(checkcode==course_code){
                                                    String sql="update course set description ='"+course_description+"' where code="+course_code+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo course available on that code\n");
                                            }
                                            else{
                                                System.out.println("\nCourse Registered Successfully\n");
                                            }
                                            
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    
                                    if(aachoice==4){
                                        System.out.print("Please enter the Course Code you want to make change: ");
                                        int course_code=Integer.parseInt(sc.next());
                                        System.out.print("Course Capacity: ");
                                        int course_capacity=sc.nextInt();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from course;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkcode=rs.getInt(1);
                                                if(checkcode==course_code){
                                                    String sql="update course set capacity ='"+course_capacity+"' where code="+course_code+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo course available on that code\n");
                                            }
                                            else{
                                                System.out.println("\nCourse Registered Successfully\n");
                                            }  
                                            
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    if(aachoice==5){
                                        System.out.print("Please enter the Course Code you want to make change: ");
                                        int course_code=Integer.parseInt(sc.next());
                                        System.out.print("Course Schedule: ");
                                        String course_schedule=sc.next();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from course;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkcode=rs.getInt(1);
                                                if(checkcode==course_code){
                                                    String sql="update course set capacity ='"+course_schedule+"' where code="+course_code+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo course available on that code\n");
                                            }
                                            else{
                                                System.out.println("\nCourse Registered Successfully\n");
                                            }  
                                            
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                        f3=false;
                                    }
                                    if(aachoice==6){
                                        System.out.print("Please enter the Course Code you want to make change: ");
                                        int course_code=Integer.parseInt(sc.next());
                                        sc.nextLine();
                                        System.out.print("Course Code: ");
                                        int course_code1=Integer.parseInt(sc.next());
                                        sc.nextLine();
                                        System.out.print("Course Title: ");
                                        String course_title=sc.nextLine();
                                        System.out.print("Course Descritpion: ");
                                        String course_description=sc.nextLine();
                                        System.out.print("Course Capacity: ");
                                        int course_capacity=sc.nextInt();
                                        System.out.print("Course Schedule: ");
                                        String course_schedule=sc.next();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from course;"); 
                                            check=true;
                                            while(rs.next()) {
                                                int checkcode=rs.getInt(1);
                                                if(checkcode==course_code){
                                                    String sql="update course set code ='"+course_code1+"',title='"+course_title+"',description='"+course_description+"',capacity="+course_capacity+",schedule='"+course_schedule+"' where code="+course_code+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nNo course available on that code\n");
                                            }
                                            else{
                                                System.out.println("\nCourse Registered Successfully\n");
                                            } 
                                            
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                    }
                                    else if(aachoice==7){
                                        f3=false;
                                    }
                                    else{
                                        System.out.println("Please enter a valid number!");
                                    }
                                }
                                f2=false;
                            }
                            else if(achoice==5){
                                try{  
                                    Class.forName("com.mysql.cj.jdbc.Driver");  
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                    Statement stmt=con.createStatement();
                                    ResultSet rs=stmt.executeQuery("select * from course;"); 
                                    while(rs.next()) {
                                        System.out.print("Course Code: \t\t"+rs.getString(1));  
                                        System.out.print("\nCourse Title: \t\t"+rs.getString(2));  
                                        System.out.print("\nCourse Description: \t"+rs.getString(3));  
                                        System.out.print("\nCourse Capacity: \t"+rs.getString(4));  
                                        System.out.print("\nCourse Timing: \t\t"+rs.getString(5)); 
                                        System.out.println("\n__________________________________________________________________________________________________________");

                                    }
                                    con.close();  
                                    }
                                catch(Exception e){ 
                                    System.out.println(e);
                                }
                                f2=false;
                            }
                            else if(achoice==6){
                                try{  
                                    Class.forName("com.mysql.cj.jdbc.Driver");  
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                    Statement stmt=con.createStatement();
                                    ResultSet rs=stmt.executeQuery("select * from studentdetail;"); 
                                    while(rs.next()) {
                                        System.out.print("Student ID: \t"+rs.getString(1));  
                                        System.out.print("\nStudent Name: \t"+rs.getString(2));  
                                        System.out.print("\nDOB: \t\t"+rs.getString(3)); 
                                        System.out.println("\n__________________________________________________________________________________________________________");

                                    }
                                    con.close();  
                                    }
                                catch(Exception e){ 
                                    System.out.println(e);
                                }
                                f2=false;
                            }
                            else if(achoice==7){
                                f2=false;
                                f1=false;
                            }
                            else{
                                System.out.println("Please enter a valid number!");
                            }
                            }
                        } 
                    }
                    else{
                        System.out.println("\nInvalid ID/Passkey!\n");
                        f1=false;
                    }
                }
                else if(choice==2){
                    System.out.print("\t\t>>> Student Login <<<\nEnter your Student ID: ");
                    int stu_id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter DOB: ");
                    int stu_dob=sc.nextInt();
                    try{  
                        Class.forName("com.mysql.cj.jdbc.Driver");  
                        Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                        Statement stmt2=con2.createStatement();
                        ResultSet rs2=stmt2.executeQuery("select * from studentdetail;"); 
                        check1=true;
                        while(rs2.next()){
                            int stu_id_c=rs2.getInt(1);
                            String stu_name=rs2.getString(2);
                            int dob_c=rs2.getInt(3);
                            if(stu_id==stu_id_c && stu_dob==dob_c){
                                check1=false;
                                f4=true;
                                while(f4){
                                    System.out.println("\n1.Register Course\n2.View Available Course\n3.View Registered Course\n4.Remove Registered Course\n5.Exit");
                                    int schoice=sc.nextInt();
                                    if(schoice==1){
                                        System.out.print("\nEnter code of the selected course: ");
                                        int stu_code=sc.nextInt();
                                        try{  
                                                Class.forName("com.mysql.cj.jdbc.Driver");  
                                                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                                Statement stmt=con.createStatement();
                                                ResultSet rs=stmt.executeQuery("select * from course;"); 
                                                check=true;
                                                while(rs.next()) {
                                                    int checkcode=rs.getInt(1);
                                                    if(checkcode==stu_code){
                                                        int capacity=rs.getInt(4)-1;
                                                        String sql="insert into student values(?,?,?)";
                                                        PreparedStatement ps=con.prepareStatement(sql);
                                                        ps.setInt(1, stu_id);
                                                        ps.setString(2, stu_name);
                                                        ps.setInt(3, stu_code);
                                                        ps.executeUpdate();
                                                        String sql1="update course set capacity="+capacity+" where code="+checkcode+";";
                                                        PreparedStatement ps1=con.prepareStatement(sql1);
                                                        ps1.executeUpdate();
                                                        check=false;
                                                    }
                                                }
                                                if(check){
                                                    System.out.println("\nNo course available on that code\n");
                                                }
                                                else{
                                                    System.out.println("\nCourse Registered Successfully\n");
                                                }
                                                con.close();  
                                                }
                                            catch(Exception e){ 
                                                System.out.println(e);
                                            }

                                    }
                                    else if(schoice==2){
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from course;"); 
                                            System.out.println("\n__________________________________________________________________________________________________________\n");
                                            while(rs.next()) {
                                                System.out.print("Course Code: \t\t"+rs.getString(1));  
                                                System.out.print("\nCourse Title: \t\t"+rs.getString(2));  
                                                System.out.print("\nCourse Description: \t"+rs.getString(3));  
                                                System.out.print("\nCourse Capacity: \t"+rs.getString(4));  
                                                System.out.print("\nCourse Timing: \t\t"+rs.getString(5)); 
                                                System.out.println("\n__________________________________________________________________________________________________________\n");

                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                    }
                                    else if(schoice==3){
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from student where stuID="+stu_id+" ;");
                                            while(rs.next()) {
                                                System.out.print("Student ID: \t"+rs.getString(1));  
                                                System.out.print("\nStudent Name: \t"+rs.getString(2));  
                                                System.out.print("\nCourse Code: \t"+rs.getString(3));  
                                                System.out.println("\n__________________________________________________________________________________________________________");

                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                    }
                                    else if(schoice==4){
                                        System.out.print("\nEnter the course code you want to remove: ");
                                        int course_code=sc.nextInt();
                                        try{  
                                            Class.forName("com.mysql.cj.jdbc.Driver");  
                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interntask","root","Rahul@2001");  
                                            Statement stmt=con.createStatement();
                                            Statement stmt1=con.createStatement();
                                            ResultSet rs=stmt.executeQuery("select * from student;"); 
                                            ResultSet rs1=stmt1.executeQuery("select * from course;");
                                            check=true;
                                            while(rs.next()){
                                                int course_code1=rs.getInt(3);
                                                int stu_id1=rs.getInt(1);
                                                if((course_code==course_code1) && (stu_id==stu_id1)){
                                                    String sql="delete from student where code="+course_code+" and stuID="+stu_id+";";
                                                    PreparedStatement ps=con.prepareStatement(sql);
                                                    ps.executeUpdate(sql);
                                                    check=false;
                                                }
                                            }
                                            if(check){
                                                System.out.println("\nYou don't have course on that code");
                                            }
                                            else{
                                                System.out.println("\nCourse deleted sucessfully");
                                                while (rs1.next()) {
                                                    if(course_code==rs1.getInt(1)){
                                                        int capacity=rs1.getInt(4)+1;
                                                        String sql1="update course set capacity="+capacity+" where code="+course_code+";";
                                                        PreparedStatement ps1=con.prepareStatement(sql1);
                                                        ps1.executeUpdate();
                                                    }
                                                }
                                            }
                                            con.close();  
                                            }
                                        catch(Exception e){ 
                                            System.out.println(e);
                                        }
                                    }
                                    else if(schoice==5){
                                        f4=false;
                                        f1=false;
                                    }
                                    else{
                                        System.out.println("\nPlease enter a valid number!");
                                    }
                                }
                            }
                        }
                        if(check1){
                            System.out.println("\nInvalid ID/DOB");
                            f1=false;
                        }
                    }
                    catch(Exception e){ 
                        System.out.println(e);
                    }
                }      
                else if(choice==3){
                    f=false;
                }
                else{
                    System.out.println("\nPlease enter a valid number!");
                    f1=false;
                }
            }  
        }
    }
}

