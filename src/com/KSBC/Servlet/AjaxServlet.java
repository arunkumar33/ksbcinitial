package com.KSBC.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.KSBC.AccountJSPRelatedFunctions.AccountJSPRelatedFunctionsImp;
import com.KSBC.Bean.AbsentBean;
import com.KSBC.Bean.CashSectionMonthlyReport;
import com.KSBC.Bean.EligibleKARChanges;
import com.KSBC.Bean.EligibleKARChangesConfirm;
import com.KSBC.Bean.EnrollmentDetails;
import com.KSBC.Bean.FeeStructureForKAR;
import com.KSBC.Bean.FiveHundreadPayedAdvocateBean;
import com.KSBC.Bean.LifeTimeMembership;
import com.KSBC.Bean.RegistrationFormBean;
import com.KSBC.Bean.ScheduleConfirmationBean;
import com.KSBC.Bean.ThousandPayedAdvocateBean;
import com.KSBC.Bean.ValidatedFinalBean;
import com.KSBC.Bean.ValidatedPayedRegistrationChallan;
import com.KSBC.JSPRelatedFunctions.JSPRelatedFunctionsimp;
import com.KSBC.Util.HibernateUtil;

/**
 * Servlet implementation class AjaxServlet
 */
/*@WebServlet("/AjaxServlet")*/
public class AjaxServlet extends HttpServlet {
	public static final org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(AjaxServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpSe
     * rvlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("******** coming to Ajax Servlet ***********");
		  String responseString="";
		  HttpSession Session = request.getSession();
		 String AjaxPage=request.getParameter("WhichFunctionToHandle");
		 log.info(AjaxPage);
		 System.out.println(AjaxPage);
		 log.info("Yes Its working");
		 
		/*int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));*/
		 String greetings = "Hello " + AjaxPage + "  " ;
		 JSPRelatedFunctionsimp JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
         
         

		    if (AjaxPage.equalsIgnoreCase("ScheduleInterview"))
		    {

		      log.info("Yes Its working");
		      String RegNumber = request.getParameter("RegNumber");
		      System.out.println(RegNumber);
		      
		      ValidatedPayedRegistrationChallan GetDetailsForRegNumber = JSPRelatedFunctionsimp.GetDetailsForRegNumberFromValidatedPayedRegistrationChallan(RegNumber);
		      System.out.println(GetDetailsForRegNumber);
		      if (GetDetailsForRegNumber == null)
		      {
		        responseString = "<h2>Please enter Valid Registration Number</h2>";
		      }
		      else
		      {
		        responseString = "<h1>Hi.. Your Scheduling Interview For <b>" + GetDetailsForRegNumber.getRegNumber() + "</b> For this register Number</h1>";
		        

		        responseString = responseString + "<form id='FormForScheduleInterview'><input type='date' value=''  name='SchedulingDate' id='SchedulingDate'><input type='hidden' value='" + GetDetailsForRegNumber.getRegNumber() + "'  name='RegNumber' id='RegNumber'><input type='hidden' value='ScheduleInterviewWithDate' name='WhichFunctionToHandle' id='WhichFunctionToHandle'><input type='button' class='btn btn-info' name='ScheduleInterview' value='Schedule Interview'  id='ScheduleInterview'  >\t</form> <script>     $('#ScheduleInterview').click(function(event) { alert('********** ScheduleInterview ***********'); var RegNumber=$('#RegNumber').val();  var SchedulingDate=$('#SchedulingDate').val(); var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();         $.get('AjaxServlet',{SchedulingDate:SchedulingDate,RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {   $('#Main_Content1').html(responseText);  });   });     </script> ";










		      }
		      










		    }
		     if (AjaxPage.equalsIgnoreCase("FeeReciptByKARNumber"))
		    {
		      String KARNumber = request.getParameter("KARNumber");
		      System.out.println(KARNumber);
		      
		      if ((KARNumber != null) && (KARNumber != ""))
		      {




		        AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		        


		        responseString = "<table class='table table-striped'><thead><tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr> </thead><tbody> <tr>  <th scope='row'>1</th> <td>Mark</td>  <td>Otto</td>  <td>@mdo</td> </tr> <tr>   <th scope='row'>2</th>  <td>Jacob</td>  <td>Thornton</td>  <td>@fat</td> </tr>  <tr>   <th scope='row'>3</th>   <td>Larry</td>   <td>the Bird</td>   <td>@twitter</td>  </tr>  </tbody> </table>";













		      }
		      













		    }
		     if (AjaxPage.equalsIgnoreCase("AddPhoto"))
		    {
		      String RegNumber = request.getParameter("RegNumber");
		      HttpSession HTTPSession = request.getSession(false);
		      if (HTTPSession == null)
		      {
		        HTTPSession = request.getSession(true);
		      }
		      HTTPSession.setAttribute("KARNumber", RegNumber);
		      
		      System.out.println(HTTPSession.getAttribute("KARNumber"));
		      


		      responseString = "<form action='OfflineFileImageUpload' method='post' enctype='multipart/form-data'><div class='form-group'> <label class='col-md-4 control-label'>Upload your Photo (Must not more then 500KB only jpg and png is allowed)</label>  <div class='col-md-4 inputGroupContainer'>  <div class='input-group'>   <span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span>   <input type='file' name='ChallanFile' size='50' /> </br></br>   <button type='submit' class='btn btn-warning'>Next Step <span class='glyphicon glyphicon-send'></span></button> </div>  </div>  </div> </form>";
		    }
		    
		   








		      if (AjaxPage.equalsIgnoreCase("AddPhotoChairman"))
		      {

		        try
		        {
		          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		          String StartDate = request.getParameter("StartDate");
		          String EndDate = request.getParameter("EndDate");
		          String Name = request.getParameter("Name");
		          String Desc = request.getParameter("Desc");
		          
		          java.util.Date parsedStartDate = null;
		          java.util.Date parsedEndDate = null;
		          java.sql.Date StartDateSQLdate = null;
		          java.sql.Date EndDateSQLdate = null;
		          
		          try
		          {
		            parsedStartDate = format.parse(StartDate);
		            parsedEndDate = format.parse(EndDate);
		            StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		            EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		          }
		          catch (ParseException e) {
		            e.printStackTrace();
		          }
		          
		          HttpSession HTTPSession = request.getSession(false);
		          if (HTTPSession == null)
		          {
		            HTTPSession = request.getSession(true);
		          }
		          HTTPSession.setAttribute("Name", Name);
		          HTTPSession.setAttribute("Desc", Desc);
		          HTTPSession.setAttribute("From", StartDateSQLdate);
		          HTTPSession.setAttribute("To", EndDateSQLdate);
		          
		          System.out.println(HTTPSession.getAttribute("KARNumber"));
		          


		          responseString = "<form action='OfflineChairmanImageUpload' method='post' enctype='multipart/form-data'><div class='form-group'> <label class='col-md-4 control-label'>Upload your Photo (Must not more then 500KB only jpg and png is allowed)</label>  <div class='col-md-4 inputGroupContainer'>  <div class='input-group'>   <span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span>   <input type='file' name='ChallanFile' size='50' /> </br></br>   <button type='submit' class='btn btn-warning'>Next Step <span class='glyphicon glyphicon-send'></span></button> </div>  </div>  </div> </form>";









		        }
		        catch (Exception e)
		        {








		          e.printStackTrace();
		          responseString = "Sorry Something Went Wrong";
		        }
		        
		      }
		       if (AjaxPage.equalsIgnoreCase("EnrollmentFeeWithoutRegNumber"))
		      {
		        String KARNumber = request.getParameter("KARNumber");
		        System.out.println(KARNumber);
		        AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		        

		        String HTMLContent = "<!DOCTYPE html><html><head>\t<title></title></head><body>hi</body></html>";
		        







		        responseString = "<table class='table table-striped'><thead><tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr> </thead><tbody> <tr>  <th scope='row'>1</th> <td>Mark</td>  <td>Otto</td>  <td>@mdo</td> </tr> <tr>   <th scope='row'>2</th>  <td>Jacob</td>  <td>Thornton</td>  <td>@fat</td> </tr>  <tr>   <th scope='row'>3</th>   <td>Larry</td>   <td>the Bird</td>   <td>@twitter</td>  </tr>  </tbody> </table>";
























		      }
		       if (AjaxPage.equalsIgnoreCase("EnrollmentFee"))
		      {
		        String KARNumber = request.getParameter("KARNumber");
		        System.out.println(KARNumber);
		        AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		        


		        responseString = "<table class='table table-striped'><thead><tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr> </thead><tbody> <tr>  <th scope='row'>1</th> <td>Mark</td>  <td>Otto</td>  <td>@mdo</td> </tr> <tr>   <th scope='row'>2</th>  <td>Jacob</td>  <td>Thornton</td>  <td>@fat</td> </tr>  <tr>   <th scope='row'>3</th>   <td>Larry</td>   <td>the Bird</td>   <td>@twitter</td>  </tr>  </tbody> </table>";
























		      }
		       if (AjaxPage.equalsIgnoreCase("VerifyChallanWithRegNumber"))
		      {
		        String RegNumber = request.getParameter("RegNumber");
		        
		        if ((RegNumber == null) || (RegNumber == ""))
		        {
		          System.out.println("***** From Select All ********");
		          


		          AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		          

		          ArrayList<RegistrationFormBean> RegisterArray = AccountJSPRelatedFunctionsImp.GetAllChallanTransactionReport();
		          if (RegisterArray == null)
		          {
		            responseString = "Sorry the register Number does not exist";

		          }
		          else
		          {

		            responseString = "<table class='table table-striped'><thead><tr><th>#</th><th>Reg Number</th><th>Name/th><th>Address</th><th>Reg Number</th><th>City</th><th>Email</th> <th>View Challan</th><th>Verify</th> </tr> </thead><tbody>";
		            



		            int indexForRegistrationBean = 1;
		            for (RegistrationFormBean RegBean : RegisterArray)
		            {








































		              responseString = responseString + "  <th scope='row'>" + indexForRegistrationBean + "</th> <td> " + RegBean.getRegNumber() + "</td> <td> " + RegBean.getFullName() + "</td> <td> " + RegBean.getAddress() + "</td> <td> " + RegBean.getRegNumber() + "</td> <td> " + RegBean.getCity() + "</td> <td> " + RegBean.getEmail() + "</td> <td>    <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletFromJSP('" + RegBean.getRegNumber() + "','ConfirmChallanPay');\" >ConfirmChallanPay</button></td> <td>      <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletForImage('" + RegBean.getRegNumber() + "','ChallanScanedCopy','ChallanScanedCopyLoad');\" >See Challan </button></td> </tr>";
		              





















		              indexForRegistrationBean++;
		            }
		            

		            responseString = responseString + " </tbody> </table>";










		          }
		          











		        }
		        else
		        {










		          System.out.println("***** From Select  ********");
		          
		          AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		          

		          RegistrationFormBean RegBean = JSPRelatedFunctionsimp.GetDetailsForRegNumber(RegNumber);
		          
		          if (RegBean == null)
		          {
		            responseString = "Sorry the register Number does not exist";




















		          }
		          else
		          {



















		            responseString = "<table class='table table-striped'><thead><tr><th>#</th><th>Reg Number</th><th>Name/th><th>Address</th><th>Reg Number</th><th>City</th><th>Email</th> <th>View Challan</th><th>Verify</th> </tr> </thead><tbody> <tr>  <th scope='row'>1</th> <td> " + RegBean.getRegNumber() + "</td> <td> " + RegBean.getFullName() + "</td> <td> " + RegBean.getAddress() + "</td> <td> " + RegBean.getRegNumber() + "</td> <td> " + RegBean.getCity() + "</td> <td> " + RegBean.getEmail() + "</td> <td> <form id='FormForScheduleInterview'><input type='hidden' value='" + RegBean.getRegNumber() + "'  name='RegNumber' id='RegNumber'><input type='hidden' value='ConfirmChallanPay' name='WhichFunctionToHandle' id='WhichFunctionToHandle'><input type='button' class='btn btn-info' name='ConfirmChallanPay' value='ConfirmChallanPay'  id='ConfirmChallanPay'  >\t</form> <script>     $('#ConfirmChallanPay').click(function(event) { alert('********** challan ***********'); var RegNumber=$('#RegNumber').val(); var WhichFunctionToHandle=$('#WhichFunctionToHandle').val();         $.get('AjaxServlet',{RegNumber:RegNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {   $('#Main_Content1').html(responseText);  });   });     </script> </td> <td>      <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletForImage('" + RegBean.getRegNumber() + "','ChallanScanedCopy','ChallanScanedCopyLoad');\" >Challan Payed</button></td> </tr> </tbody> </table>";















		          }
		          















		        }
		        
















		      }
		       if (!AjaxPage.equalsIgnoreCase("CallToServletFromJSPForNewEnrollmentTodoList"))
		      {
		    	  
					/* String RegNumber = request.getParameter("RegNumber");
					 System.out.println(request.getParameter("RegNumber"));
					 AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
					String ResultOfMovingToverfiedBean = AccountJSPRelatedFunctionsImp.MoveToVerifiedPayedRegistrationChallan(RegNumber);
					 responseString=ResultOfMovingToverfiedBean;*/
				//	 response.sendRedirect("index1.jsp");  
				
		      }



		      else   if (AjaxPage.equalsIgnoreCase("StampSectionAssociation"))
		        {

		          Session Session1 = HibernateUtil.getSessionFactory().openSession();
		          
		          String districtName = request.getParameter("district");
		          System.out.println(districtName);
		          

		          String associationName = request.getParameter(districtName);
		          System.out.println(associationName + "associationName1");
		          

		         String StampFee=request.getParameter("StampFee");
				int Stampfee=Integer.parseInt(StampFee);
				System.out.println("StampFee"+Stampfee);
			
		          
		          String NAmount = request.getParameter("NetAmount");
		          
		          try
		          {
		            int NetAmount = Integer.parseInt(NAmount);
		            System.out.println("NetAmount" + NetAmount);
		          }
		          catch (Exception e)
		          {
		            e.printStackTrace();
		          }
		          



		          String RecepitNumber = request.getParameter("RecepitNumber");
		          
		          int rn = 0;
		          
		          try
		          {
		            rn = Integer.parseInt(RecepitNumber);
		          }
		          catch (Exception e)
		          {
		            e.printStackTrace();
		          }
		          






		          String PostalCharge = request.getParameter("PostalCharges");
		          int PostalCharges = 0;
		          try
		          {
		            PostalCharges = Integer.parseInt(PostalCharge);

		          }
		          catch (Exception e)
		          {
		            e.printStackTrace();
		          }
		          
		          System.out.println(PostalCharges);
		          

		          String BeforeDis = request.getParameter("BeforeDiscount");
		          

		          System.out.println(BeforeDis + " BeforeDis");
		          
		          LocalDate today = LocalDate.now();
		          
		          java.util.Date date = java.util.Date.from(today.atStartOfDay()
		            .atZone(ZoneId.systemDefault()).toInstant());
		          Timestamp timeStamp = new Timestamp(date.getTime());
		          


		          System.out.println(timeStamp);
		          String Remarks = request.getParameter("remarks");
		          System.out.println(Remarks);
		          
		          CashSectionMonthlyReport CashSectionMonthlyReport = (CashSectionMonthlyReport)Session1.get(CashSectionMonthlyReport.class, Integer.valueOf(rn));
		          
		          int totalAmount = CashSectionMonthlyReport.getAmount();
		          
		          int FinalAmount = totalAmount - PostalCharges;
		          
		          System.out.println(FinalAmount + "FinalAmount");
		          int Gross_Amount = 0;
		          if ("Before".equals(BeforeDis))
		          {

		            System.out.println(BeforeDis + " after");
		            System.out.println("Before");
		            Gross_Amount = (int)(FinalAmount * 1.1D);
		            System.out.println(Gross_Amount + " Before");

		          }
		          else if ("After".equals(BeforeDis))
		          {
		            Gross_Amount = FinalAmount * 10 / 9;
		            
		            System.out.println(Gross_Amount + " After");
		          }
		          
		         int totalStamp=Gross_Amount/Stampfee;
		          
		          System.out.println(totalStamp + " totalStamp");
		          System.out.println(CashSectionMonthlyReport.getPlace() + " Place");
		          


		          responseString = NAmount + "div" + Gross_Amount + "div" + totalAmount + "div" + totalStamp + "div" + CashSectionMonthlyReport.getEnrollNo() + "div" + CashSectionMonthlyReport.getName() + "div" + CashSectionMonthlyReport.getPlace();


		        }
		        if (AjaxPage.equalsIgnoreCase("ConfirmChallanPay"))
		        {

		          String RegNumber = request.getParameter("RegNumber");
		          System.out.println(request.getParameter("RegNumber"));
		          AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		          String ResultOfMovingToverfiedBean = AccountJSPRelatedFunctionsImp.MoveToVerifiedPayedRegistrationChallan(RegNumber);
		          responseString = ResultOfMovingToverfiedBean;



		        }
		        if (AjaxPage.equalsIgnoreCase("StampAssociationLoader"))
		        {
		          String OutputStamp = "";
		          System.out.println("StampAssociationLoader");
		          String selectedDistrict = request.getParameter("selectedDistrict");
		          String selectedDistrictName = request.getParameter("selectedDistrictName");
		          switch (selectedDistrictName) {
		          case "BANGALORE DISTRICT": 
		            OutputStamp = "<select><option value=\"BENGALURU BAR ASSOCIATION\">BENGALURU BAR ASSOCIATION</option> <option value=\"BENGALURU ADV CO-OPERATIVE SOCIETY\">BENGALURU  ADV CO-OPERATIVE SOCIETY</option> <option value=\"ANEKAL BAR ASSOCIATION\">ANEKAL BAR ASSOCIATION</option>  <option value=\"DEVANAHALLI BAR ASSOCIATION\">DEVANAHALLI BAR ASSOCIATION</option>  <option value=\"DODDABALLAPUR BAR ASSOCIATION\">DODDABALLAPUR BAR ASSOCIATION</option>  <option value=\"HOSAKOTE BAR ASSOCIATION\">HOSAKOTE BAR ASSOCIATION</option>  <option value=\"NELAMANGALA BAR ASSOCIATION\">NELAMANGALA BAR ASSOCIATION</option></select>";
		            








		            break;
		          case "BAGALKOT": 
		            OutputStamp = "<select> <option value=\"BAGALKOT BAR ASSOCIATION\">BAGALKOT BAR ASSOCIATION</option>  <option value=\"BAGALKOT ADV CO-OPERATIVE SOCIETY\">BAGALKOT  ADV CO-OPERATIVE SOCIETY</option>   <option value=\"BADAMI BAR ASSOCIATION\">BADAMI BAR ASSOCIATION</option>  <option value=\"BANAHATTI BAR ASSOCIATION\">BANAHATTI BAR ASSOCIATION</option>  <option value=\"BILIGI BAR ASSOCIATION\">BILIGI BAR ASSOCIATION</option>   <option value=\"GULEDAGUDDA BAR ASSOCIATION\">GULEDAGUDDA BAR ASSOCIATION</option>  <option value=\"HUNGUND BAR ASSOCIATION \">HUNGUND BAR ASSOCIATION </option>  <option value=\"ILKAL BAR ASSOCIATION\">ILKAL BAR ASSOCIATION</option>   <option value=\"JAMAKHANDI BAR ASSOCIATION\">JAMAKHANDI BAR ASSOCIATION</option>  <option value=\"MUDHOL BAR ASSOCIATION\">MUDHOL BAR ASSOCIATION</option> </select>";
		            














		            break;
		          case "BELAGAUM": 
		            OutputStamp = "<select>  <option value=\"BELAGAUM BAR ASSOCIATION\">BELAGAUM BAR ASSOCIATION</option>    <option value=\"BELAGAUM ADV CO-OPERATIVE SOCIETY\">BELAGAUM  ADV CO-OPERATIVE SOCIETY</option>   <option value=\"ATHANI BAR ASSOCIATION\">ATHANI BAR ASSOCIATION</option>   <option value=\"BELGAUM CITY BAR ASSOCIATION\">BELGAUM CITY BAR ASSOCIATION</option>   <option value=\"BAILAHONGAL BAR ASSOCIATION\">BAILAHONGAL BAR ASSOCIATION</option>    <option value=\"CHIKODI BAR ASSOCIATION\">CHIKODI BAR ASSOCIATION</option>   <option value=\"GOKAK BAR ASSOCIATION\">GOKAK BAR ASSOCIATION</option>  <option value=\"HUKKERI BAR ASSOCIATION\">HUKKERI BAR ASSOCIATION</option>   <option value=\"KHANAPUR BAR ASSOCIATION\">KHANAPUR BAR ASSOCIATION</option>   <option value=\"KITTUR, Bailhongal TQ BAR ASSOCIATION\">KITTUR, Bailhongal TQ BAR ASSOCIATION</option>    <option value=\"RAMADURGA BAR ASSOCIATION\">RAMADURGA BAR ASSOCIATION</option>     <option value=\"RAIBAG BAR ASSOCIATION\">RAIBAG BAR ASSOCIATION</option>     <option value=\"SANKESHWAR BAR ASSOCIATION\">SANKESHWAR BAR ASSOCIATION</option>    <option value=\"SAUNDATTI BAR ASSOCIATION\">SAUNDATTI BAR ASSOCIATION</option>    <option value=\"MUDALAGI BAR ASSOCIATION\">MUDALAGI BAR ASSOCIATION</option> </select>";
		            

























		            break;
		          case "BELLARY": 
		            OutputStamp = "<select> <option value=\"BELLARY  BAR ASSOCIATION\">BELLARY  BAR ASSOCIATION</option>  <option value=\"BELLARY ADV CO-OPERATIVE SOCIETY\">BELLARY  ADV CO-OPERATIVE SOCIETY</option>   <option value=\"HADAGLI CITY BAR ASSOCIATION\">HADAGLI CITY BAR ASSOCIATION</option>  <option value=\"HAGARAI BOMMANAHAHALLI BAR ASSOCIATION\">HAGARAI BOMMANAHAHALLI BAR ASSOCIATION</option>   <option value=\"HOSPET BAR ASSOCIATION\">HOSPET BAR ASSOCIATION</option>   <option value=\"KUDLIGI BAR ASSOCIATION\">KUDLIGI BAR ASSOCIATION </option>   <option value=\"SANDUR BAR ASSOCIATION\">SANDUR BAR ASSOCIATION</option>  <option value=\"SIRUGUPPA BAR ASSOCIATION\">SIRUGUPPA BAR ASSOCIATION</option> </select>";
		            













		            break;
		          case "BIDAR": 
		            OutputStamp = "";
		            break;
		          case "BIJAPUR": 
		            OutputStamp = "";
		            break;
		          case "CHAMARAJNAGAR": 
		            OutputStamp = "";
		            break;
		          case "CHIKKAMAGALUR": 
		            OutputStamp = "";
		            break;
		          case "CHITRADURGA": 
		            OutputStamp = "";
		            break;
		          case "DAVANGERE": 
		            OutputStamp = "";
		            break;
		          case "COORG": 
		            OutputStamp = "";
		            break;
		          case "DHARWAD": 
		            OutputStamp = "";
		            break;
		          case "GADAG": 
		            OutputStamp = "";
		            break;
		          case "GULBARGA": 
		            OutputStamp = "";
		            break;
		          case "HASSAN": 
		            OutputStamp = "";
		            break;
		          case "HAVERI": 
		            OutputStamp = "";
		            break;
		          case "KOLAR": 
		            OutputStamp = "";
		            break;
		          case "KOPPAL": 
		            OutputStamp = "";
		            break;
		          case "MANDYA": 
		            OutputStamp = "";
		            break;
		          case "MANGALORE": 
		            OutputStamp = "";
		            break;
		          case "MYSORE": 
		            OutputStamp = "";
		            break;
		          case "NORTH KARNATAKA DIST.": 
		            OutputStamp = "";
		            break;
		          case "RAMANAGAR": 
		            OutputStamp = "";
		            break;
		          case "RAICHUR": 
		            OutputStamp = "";
		            break;
		          case "SHIMOGA": 
		            OutputStamp = "";
		            break;
		          case "TUMKUR": 
		            OutputStamp = "";
		            break;
		          case "UDUPI": 
		            OutputStamp = "";
		            break;
		          case "YADGIRI": 
		            OutputStamp = "";
		          }
		          
		          



		          responseString = OutputStamp;

		        }
		        if (AjaxPage.equalsIgnoreCase("MoveDataFromValidatedBeantoEnrollment"))
		        {

		          JSPRelatedFunctionsimp AccountJSPRelatedFunctionsImp = new JSPRelatedFunctionsimp();
		          String ResultOfMovingToverfiedBean = AccountJSPRelatedFunctionsImp.MoveDataFromValidatedBeantoEnrollment();
		          responseString = ResultOfMovingToverfiedBean;


		        }
		        if (AjaxPage.equalsIgnoreCase("CallToServletFromJSPForWelfareTodoList"))
		        {

		          int RegNumber = Integer.parseInt(request.getParameter("ReceiptNumber"));
		          System.out.println(request.getParameter("RegNumber"));
		          JSPRelatedFunctionsimp AccountJSPRelatedFunctionsImp = new JSPRelatedFunctionsimp();
		          String ResultOfMovingToverfiedBean = AccountJSPRelatedFunctionsImp.DeleteRecordFromChallanFlow(RegNumber);
		          responseString = ResultOfMovingToverfiedBean;
		        }
		        else 
		         
		          if (AjaxPage.equalsIgnoreCase("NomineeFee"))
		          {

		            String KARNumber = request.getParameter("KARNumber");
		            
		            String RelationShip = request.getParameter("RelationShip");
		            
		            String NomineeName = request.getParameter("NomineeName");
		            JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		            String ResultOfMovingToverfiedBean = JSPRelatedFunctionsimp.ChangeTheNominee(KARNumber, NomineeName, RelationShip, "Arun");
		            responseString = ResultOfMovingToverfiedBean;

		          }
		          if (AjaxPage.equalsIgnoreCase("KARPendingFee"))
		          {

		            String KARNumber = request.getParameter("KARNumber");
		            System.out.println(request.getParameter("KARNumber"));
		            
		            String ResultOfMovingToverfiedBean = JSPRelatedFunctionsimp.GetPayBalenceForKARNumber(KARNumber);
		            responseString = ResultOfMovingToverfiedBean;



		          }
		          if (AjaxPage.equalsIgnoreCase("CertificateChecking"))
		          {

		            try
		            {
		              String KARNumber = request.getParameter("KARNumber");
		              
		              JSPRelatedFunctionsimp = new JSPRelatedFunctionsimp();
		              ArrayList<AbsentBean> absentBean = JSPRelatedFunctionsimp.ViewInterviewAbsentCandidate();
		              if (absentBean.get(0) == null)
		              {
		                responseString = "Sorry";

		              }
		              else
		              {
		                for (AbsentBean ValidatedFinalBean : absentBean)
		                {





		                  responseString = responseString + JSPRelatedFunctionsimp.GenerateCertificate(ValidatedFinalBean.getRegNumber(), ValidatedFinalBean.getFather_name(), ValidatedFinalBean.getFullName(), null, ValidatedFinalBean.getRegNumber(), 0);
		                }
		              }
		            }
		            catch (Exception e)
		            {
		             
		              


		              e.printStackTrace();
		              responseString = "Sorry";
		              System.out.println("Error");
		            }
		            

		          }
		           if (AjaxPage.equalsIgnoreCase("GetPhotoForDisplay"))
		          {

		            String KARNumber = request.getParameter("KARNumber");
		            int EnrollmentId = Integer.parseInt(request.getParameter("EnrollmentId"));
		            System.out.println(request.getParameter("KARNumber"));
		            
		            String ResultOfMovingToverfiedBean = JSPRelatedFunctionsimp.GetPhotoDetailsForWelfare(EnrollmentId);
		            responseString = ResultOfMovingToverfiedBean;
		          }
		           if (AjaxPage.equalsIgnoreCase("NomineeFeeUpdate"))
		          {
		            String KARNumber = request.getParameter("KARNumber");
		            
		            String RelationShip = request.getParameter("RelationShip");
		            
		            System.out.println(RelationShip + " Relationship");
		            String NomineeName = request.getParameter("NomineeName");
		            
		            System.out.println(NomineeName + "Nominee");
		            String Remarks = request.getParameter("Remarks");
		            System.out.println(Remarks + " Remarks");
		            
		            String ResultOfMovingToverfiedBean = JSPRelatedFunctionsimp.UpdateNomineeDetails(KARNumber, Remarks, NomineeName, RelationShip);
		            responseString = ResultOfMovingToverfiedBean;


		          }
		           if (AjaxPage.equalsIgnoreCase("UpdateCaseDetailsInDC"))
		          {
		            String CaseDetails = request.getParameter("CaseDetails");
		            
		            String ComplaintNumber = request.getParameter("ComplaintNumber");
		            


		            
		            String ResultOfMovingToverfiedBean = JSPRelatedFunctionsimp.UpdateCaseDetailsInDC(CaseDetails, ComplaintNumber);
		            responseString = ResultOfMovingToverfiedBean;

		          }
		           if (AjaxPage.equalsIgnoreCase("SearchInDCWithComplaintNo"))
		          {

		            String ComplaintNumber = request.getParameter("ComplaintNumber");
		            


		            
		            String ResultOfMovingToverfiedBean = JSPRelatedFunctionsimp.GetDetailsOfDCfromComplaintNumber(ComplaintNumber);
		            responseString = ResultOfMovingToverfiedBean;

		          }
		           if (AjaxPage.equalsIgnoreCase("AssociateMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForAssociateStampingFee(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;




		          }
		           if (AjaxPage.equalsIgnoreCase("IndividualMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForIndividualStampingFee(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;


		          }
		           if (AjaxPage.equalsIgnoreCase("ClaimMonthlyReport"))
		          {

		            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		            String StartDate = request.getParameter("StartDate");
		            String EndDate = request.getParameter("EndDate");
		            String status = "";
		            java.util.Date parsedStartDate = null;
		            java.util.Date parsedEndDate = null;
		            java.sql.Date StartDateSQLdate = null;
		            java.sql.Date EndDateSQLdate = null;
		            
		            try
		            {
		              parsedStartDate = format.parse(StartDate);
		              parsedEndDate = format.parse(EndDate);
		              StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		              EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		            }
		            catch (ParseException e) {
		              e.printStackTrace();
		            }
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            




		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForClaim(StartDateSQLdate, EndDateSQLdate, status);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;
		          }
		           if (AjaxPage.equalsIgnoreCase("WelfarePMonthlyReport"))
		          {

		            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		            String StartDate = request.getParameter("StartDate");
		            String EndDate = request.getParameter("EndDate");
		            String status = request.getParameter("Status");
		            java.util.Date parsedStartDate = null;
		            java.util.Date parsedEndDate = null;
		            java.sql.Date StartDateSQLdate = null;
		            java.sql.Date EndDateSQLdate = null;
		            
		            try
		            {
		              parsedStartDate = format.parse(StartDate);
		              parsedEndDate = format.parse(EndDate);
		              StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		              EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		            }
		            catch (ParseException e) {
		              e.printStackTrace();
		            }
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            




		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForWelfarePortalFee(StartDateSQLdate, EndDateSQLdate, status);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;



		          }
		           if (AjaxPage.equalsIgnoreCase("ResumbtionReport"))
		          {

		            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		            String StartDate = request.getParameter("StartDate");
		            String EndDate = request.getParameter("EndDate");
		            String status = "";
		            java.util.Date parsedStartDate = null;
		            java.util.Date parsedEndDate = null;
		            java.sql.Date StartDateSQLdate = null;
		            java.sql.Date EndDateSQLdate = null;
		            
		            try
		            {
		              parsedStartDate = format.parse(StartDate);
		              parsedEndDate = format.parse(EndDate);
		              StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		              EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		            }
		            catch (ParseException e) {
		              e.printStackTrace();
		            }
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            




		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForResumbption(StartDateSQLdate, EndDateSQLdate, status);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;

		          }
		           if (AjaxPage.equalsIgnoreCase("SuspentionReport"))
		          {

		            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		            String StartDate = request.getParameter("StartDate");
		            String EndDate = request.getParameter("EndDate");
		            String status = "";
		            java.util.Date parsedStartDate = null;
		            java.util.Date parsedEndDate = null;
		            java.sql.Date StartDateSQLdate = null;
		            java.sql.Date EndDateSQLdate = null;
		            
		            try
		            {
		              parsedStartDate = format.parse(StartDate);
		              parsedEndDate = format.parse(EndDate);
		              StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		              EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		            }
		            catch (ParseException e) {
		              e.printStackTrace();
		            }
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            




		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForSuspend(StartDateSQLdate, EndDateSQLdate, status);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;




		          }
		           if (AjaxPage.equalsIgnoreCase("TransferReport"))
		          {

		            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		            String StartDate = request.getParameter("StartDate");
		            String EndDate = request.getParameter("EndDate");
		            String status = "";
		            java.util.Date parsedStartDate = null;
		            java.util.Date parsedEndDate = null;
		            java.sql.Date StartDateSQLdate = null;
		            java.sql.Date EndDateSQLdate = null;
		            
		            try
		            {
		              parsedStartDate = format.parse(StartDate);
		              parsedEndDate = format.parse(EndDate);
		              StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		              EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		            }
		            catch (ParseException e) {
		              e.printStackTrace();
		            }
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            




		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForTransfor(StartDateSQLdate, EndDateSQLdate, status);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;




		          }
		           if (AjaxPage.equalsIgnoreCase("WelfareUpdate"))
		          {
		            try
		            {
		              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		              String StartDate = request.getParameter("StartDate");
		              
		              String StatusOfTheAdvocate = request.getParameter("KARNumber");
		              java.util.Date parsedStartDate = null;
		              java.util.Date parsedEndDate = null;
		              java.sql.Date StartDateSQLdate = null;
		              java.sql.Date EndDateSQLdate = null;
		              
		              try
		              {
		                parsedStartDate = format.parse(StartDate);
		                
		                StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		              }
		              catch (ParseException e)
		              {
		                e.printStackTrace();
		              }
		              
		              
		              responseString = JSPRelatedFunctionsimp.UpdateWelfareEnrollDate(StatusOfTheAdvocate, StartDateSQLdate);
		              System.out.println(responseString);
		              if (responseString == null)
		              {
		                System.out.println("There is not data");
		                responseString = "Sorry there is no data";
		                System.out.println("Coming to HTMLContent if part");
		              }
		              else
		              {
		                System.out.println("Coming to else if part");
		                
		                responseString = "Updated";
		              }
		              
		            }
		            catch (Exception e)
		            {
		              e.printStackTrace();
		              responseString = "Sorry Something Went Wrong";

		            }
		            

		          }
		           if (AjaxPage.equalsIgnoreCase("KSBCOPPMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GenerateCOPMnthlyReport(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;

		          }
		           if (AjaxPage.equalsIgnoreCase("KSBCMiscMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForKSBCMiscFee(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;



		          }
		           if (AjaxPage.equalsIgnoreCase("StampInididualMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForIndividualStampingFee(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;

		          }
		           if (AjaxPage.equalsIgnoreCase("StampsecInididualMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		             String result = JSPRelatedFunctionsimp.GenerateStampSectionIndividualMnthlyReport(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;


		          }
		           if (AjaxPage.equalsIgnoreCase("StampAssociationMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GetMonthlyReportForAssociateStampingFee(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result;


		          }
		           if (AjaxPage.equalsIgnoreCase("StampsecAssociationMonthlyReport"))
		          {
		            String EndDate = request.getParameter("EndDate");
		            String StartDate = request.getParameter("StartDate");
		            
		            System.out.println(request.getParameter("StartDate"));
		            System.out.println(request.getParameter("EndDate"));
		            



		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		            

		            String date = "16/08/2016";
		            

		            LocalDate localDateStart = LocalDate.parse(StartDate, formatter);
		            LocalDate localDateEnd = LocalDate.parse(EndDate, formatter);
		            
		            String result = JSPRelatedFunctionsimp.GenerateStampSectionAssosiationMnthlyReport(localDateStart, localDateEnd);
		            System.out.println(localDateStart + "  Star date");
		            System.out.println(localDateEnd + "  End date");
		            
		            responseString = result; } /*else { DateTimeFormatter formatter;
		            LocalDate localDateStart;
		            LocalDate localDateEnd;*/
		            if (AjaxPage.equalsIgnoreCase("LifeMemberMonthlyReport"))
		            {
		            	DateTimeFormatter formatter;
			            LocalDate localDateStart;
			            LocalDate localDateEnd;
		              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		              String StartDate = request.getParameter("StartDate");
		              String EndDate = request.getParameter("EndDate");
		              String status = request.getParameter("StatusOfTheAdvocate");
		              
		              if (status == null)
		              {
		                status = "";
		              }
		              java.util.Date parsedStartDate = null;
		              java.util.Date parsedEndDate = null;
		              java.sql.Date StartDateSQLdate = null;
		              java.sql.Date EndDateSQLdate = null;
		              
		              try
		              {
		                parsedStartDate = format.parse(StartDate);
		                parsedEndDate = format.parse(EndDate);
		                StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		              }
		              catch (ParseException e) {
		                e.printStackTrace();
		              }
		              



		              formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		              




		              localDateStart = LocalDate.parse(StartDate, formatter);
		              localDateEnd = LocalDate.parse(EndDate, formatter);
		              
		              String result = JSPRelatedFunctionsimp.GetMonthlyReportForLifeTime(StartDateSQLdate, EndDateSQLdate, status);
		              System.out.println(localDateStart + "  Star date");
		              System.out.println(localDateEnd + "  End date");
		              
		              responseString = result;


		            }
		             if (AjaxPage.equalsIgnoreCase("KSBCNewMemberMonthlyReport"))
		            {
		              String EndDate = request.getParameter("EndDate");
		              String StartDate = request.getParameter("StartDate");
		              
		              System.out.println(request.getParameter("StartDate"));
		              System.out.println(request.getParameter("EndDate"));
		              



		              DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		              

		              String date = "16/08/2016";
		              

		              LocalDate localDateStart1 = LocalDate.parse(StartDate, formatter1);
		              LocalDate localDateEnd1 = LocalDate.parse(EndDate, formatter1);
		              
		              String result = JSPRelatedFunctionsimp.GetMonthlyReportForKSBCEnrollFee(localDateStart1, localDateEnd1);
		              System.out.println(localDateStart1 + "  Star date");
		              System.out.println(localDateEnd1 + "  End date");
		              
		              responseString = result;




		            }
		             if (AjaxPage.equalsIgnoreCase("SeniorAdvMonthlyReport"))
		            {
		              String EndDate = request.getParameter("EndDate");
		              String StartDate = request.getParameter("StartDate");
		              
		              System.out.println(request.getParameter("StartDate"));
		              System.out.println(request.getParameter("EndDate"));
		              



		              DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		              



		              LocalDate localDateStart1 = LocalDate.parse(StartDate, formatter1);
		              LocalDate localDateEnd1 = LocalDate.parse(EndDate, formatter1);
		              
		              String result = JSPRelatedFunctionsimp.GenerateSeniorAdvMnthlyReport(localDateStart1, localDateEnd1);
		              System.out.println(localDateStart1 + "  Star date");
		              System.out.println(localDateEnd1 + "  End date");
		              
		              responseString = result;



		            }
		             if (AjaxPage.equalsIgnoreCase("KSBCOPPMonthlyReport"))
		            {
		              String EndDate = request.getParameter("EndDate");
		              String StartDate = request.getParameter("StartDate");
		              
		              System.out.println(request.getParameter("StartDate"));
		              System.out.println(request.getParameter("EndDate"));
		              



		              DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		              

		              String date = "16/08/2016";
		              

		              LocalDate localDateStart1 = LocalDate.parse(StartDate, formatter1);
		              LocalDate localDateEnd1 = LocalDate.parse(EndDate, formatter1);
		              
		              String result = JSPRelatedFunctionsimp.GenerateCOPMnthlyReport(localDateStart1, localDateEnd1);
		              System.out.println(localDateStart1 + "  Star date");
		              System.out.println(localDateEnd1 + "  End date");
		              
		              responseString = result;


		            }
		             if (AjaxPage.equalsIgnoreCase("KSWFNewMemberMonthlyReport"))
		            {
		              String EndDate = request.getParameter("EndDate");
		              String StartDate = request.getParameter("StartDate");
		              
		              System.out.println(request.getParameter("StartDate"));
		              System.out.println(request.getParameter("EndDate"));
		              



		              DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		              

		              String date = "16/08/2016";
		              

		              LocalDate localDateStart1 = LocalDate.parse(StartDate, formatter1);
		              LocalDate localDateEnd1 = LocalDate.parse(EndDate, formatter1);
		              
		              String result = JSPRelatedFunctionsimp.GetMonthlyReportForKAWFMemberShipFee(localDateStart1, localDateEnd1);
		              System.out.println(localDateStart1 + "  Star date");
		              System.out.println(localDateEnd1 + "  End date");
		              
		              responseString = result;


		            }
		             if (AjaxPage.equalsIgnoreCase("KSWFMiscMonthlyReport"))
		            {
		              String EndDate = request.getParameter("EndDate");
		              String StartDate = request.getParameter("StartDate");
		              
		              System.out.println(request.getParameter("StartDate"));
		              System.out.println(request.getParameter("EndDate"));
		              



		              DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		              

		              String date = "16/08/2016";
		              

		              LocalDate localDateStart1 = LocalDate.parse(StartDate, formatter1);
		              LocalDate localDateEnd1 = LocalDate.parse(EndDate, formatter1);
		              
		              String result = JSPRelatedFunctionsimp.GetMonthlyReportForKAWFMisc(localDateStart1, localDateEnd1);
		              System.out.println(localDateStart1 + "  Star date");
		              System.out.println(localDateEnd1 + "  End date");
		              
		              responseString = result;



		            }
		             if (AjaxPage.equalsIgnoreCase("BCIMonthlyReport"))
		            {
		              String EndDate = request.getParameter("EndDate");
		              String StartDate = request.getParameter("StartDate");
		              
		              System.out.println(request.getParameter("StartDate"));
		              System.out.println(request.getParameter("EndDate"));
		              



		              DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		              

		              String date = "16/08/2016";
		              

		              LocalDate localDateStart1 = LocalDate.parse(StartDate, formatter1);
		              LocalDate localDateEnd1 = LocalDate.parse(EndDate, formatter1);
		              
		              String result = JSPRelatedFunctionsimp.GetMonthlyReportForBCI(localDateStart1, localDateEnd1);
		              System.out.println(localDateStart1 + "  Star date");
		              System.out.println(localDateEnd1 + "  End date");
		              
		              responseString = result;
		            }
		             if (AjaxPage.equalsIgnoreCase("SeeChallan"))
		            {
		              responseString = "<img src='img/about.jpg' class='img-responsive'>";
		            } 
		              if (AjaxPage.equalsIgnoreCase("GetEnrollMentDetails"))
		              {



		                String KARNumber = request.getParameter("KARNumber");
		                
		                EnrollmentDetails ValidatedFinalBean = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		                

		                System.out.println(ValidatedFinalBean.getEnrollmentId() + "  Enrollmentid");
		                String src = "";
		                String Privioussrc = JSPRelatedFunctionsimp.GetPhotoDetailsForWelfare(ValidatedFinalBean.getEnrollmentId());
		                
		                System.out.println(Privioussrc + "  Its what coming");
		                if (!Privioussrc.contains("Error"))
		                {
		                  src = Privioussrc;
		                }
		                else
		                {
		                  src = "ImageServlet?RegNumber=" + ValidatedFinalBean.getEnrollmentRegistrationNo() + "&WhichPhoto=Photo";
		                }
		                
		                String rem = ValidatedFinalBean.getRemarks();
		                if (rem == null)
		                {
		                  rem = "";
		                }
		                


		                responseString = ValidatedFinalBean.getName() + "div" + ValidatedFinalBean.getFatherName() + "div" + ValidatedFinalBean.getEMail() + "div" + ValidatedFinalBean.getCommunication_Address1() + ValidatedFinalBean.getCommunication_Address2() + ValidatedFinalBean.getCommunication_Address3() + "div" + ValidatedFinalBean.getMobileNo() + "div" + ValidatedFinalBean.getCommunication_City() + "div" + ValidatedFinalBean.getPlace_Of_Practice() + "div" + src + "div" + rem;
		              String Gender="";
		                
		                if(ValidatedFinalBean.getGender()=='M')
		                {
		                	Gender="Male";	
		                }
		                
		                else
		                {
		                	Gender="FeMale";
		                }
		                String Cast="";
		                if(ValidatedFinalBean.getCategoryId()==1)
		                {
		                	Cast="Genral";
		                }
		                else
		                {
		                	Cast="SC/ST";	
		                }
		                responseString = responseString + JSPRelatedFunctionsimp.PriousAddtionalInformation(ValidatedFinalBean.getEnrollmentRegistrationNo());
		                System.out.println(ValidatedFinalBean.getPermanent_Address1() + ValidatedFinalBean.getPermanent_Address2() + ValidatedFinalBean.getPermanent_Address3() + " Permenent");
		                responseString = responseString + "div" + ValidatedFinalBean.getPermanent_Address1() + ValidatedFinalBean.getPermanent_Address2() +
		                		ValidatedFinalBean.getPermanent_Address3() + 
		                		"div" +ValidatedFinalBean.getPlace_Of_Practice()+ "div" + ValidatedFinalBean.getDateOfBirth() 
+ "div" + ValidatedFinalBean.getEnrollmentDate()+ "div" + Cast+ "div" + Gender;
		                
		                }
		              
		               if (AjaxPage.equalsIgnoreCase("SearchWithKARNumberForCertificate"))
		              {



		                String KARNumber = request.getParameter("KARNumber");
		                
		                
		                EnrollmentDetails ValidatedFinalBean = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		                
       if (ValidatedFinalBean == null)
		                {
		                  responseString = "Sorry KAR number not found";
		                }
		                else
		                {
		                  responseString = "\t<!DOCTYPE html> <html> <head> <meta charset=\"ISO-8859-1\"> <title>Insert title here</title> <style type=\"text/css\"> .a {    width: 1px;   border: 1px white;   padding: 100px;    margin: 0px; } h1 { page-break-before: always; }   </style> </head> ";
		                  responseString = responseString + JSPRelatedFunctionsimp.GenerateCertificate(ValidatedFinalBean.getRollNo(), ValidatedFinalBean.getFatherName(), ValidatedFinalBean.getName(), ValidatedFinalBean.getEnrollmentDate(), ValidatedFinalBean.getEnrollmentRegistrationNo(), ValidatedFinalBean.getEnrollmentId());

		                }
		                














		              }
		               if (AjaxPage.equalsIgnoreCase("SearchWithKARNumberForCertificateStamp"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                
		                
		                EnrollmentDetails ValidatedFinalBean = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		                if (ValidatedFinalBean == null)
		                {
		                  responseString = "Sorry KAR number not found";
		                }
		                else
		                {
		                  responseString = "\t<!DOCTYPE html> <html> <head> <meta charset=\"ISO-8859-1\"> <title>Certificate</title> <style type=\"text/css\"> .a {    width: 1px;   border: 1px white;   padding: 100px;    margin: 0px; } h1 { page-break-before: always; }   </style> </head> ";
		                  
   responseString = responseString + JSPRelatedFunctionsimp.GenerateCertificateForBond(ValidatedFinalBean.getRollNo(), ValidatedFinalBean.getFatherName(), ValidatedFinalBean.getName(), ValidatedFinalBean.getEnrollmentDate(), ValidatedFinalBean.getEnrollmentRegistrationNo(), ValidatedFinalBean.getEnrollmentId());

           }
		             }
		    
		
		               if (AjaxPage.equalsIgnoreCase("GenerateAllTheCertificateAtonce"))
		              {
		            	  
		            	  System.out.println("GenerateAllTheCertificateAtonce fgdgfgfg");
		                String StartDate = request.getParameter("StartDate");
		                
		                JSPRelatedFunctionsimp JSPRelatedFunctionsimp1 = new JSPRelatedFunctionsimp();     
		                
		                responseString = JSPRelatedFunctionsimp1.GenerateAllTheCertificateAtonce(StartDate);

System.out.println(responseString + "responseString");




		              }
		               if (AjaxPage.equalsIgnoreCase("ViewDocument"))
		              {
		                String REGNumber = request.getParameter("");
		                responseString = "   <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletForImage('" + REGNumber + "','DOBCertificate','DOBImageLoad');\" >Date Of Birth Certificate</button>";
		                responseString = responseString + "</br></br>";
		                responseString = responseString + "   <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletForImage('" + REGNumber + "','ChallanScanedCopy','ChallanScanedCopyLoad');\" >Challan Payed</button>";
		                responseString = responseString + "</br></br>";
		                responseString = responseString + "   <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletForImage('" + REGNumber + "','Photo','PhotoLoad');\" >Photo</button>";
		              }
		               if (AjaxPage.equalsIgnoreCase("SearchWithKARNumberForDuplicateCertificate"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                
		                
		                EnrollmentDetails ValidatedFinalBean = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		                Timestamp dat = ValidatedFinalBean.getEnrollmentDate();
		                if (ValidatedFinalBean == null)
		                {
		                  responseString = "Sorry KAR number not found";
		                }
		                else
		                {
		                  responseString = "\t<!DOCTYPE html> <html> <head> <meta charset=\"ISO-8859-1\"> <title>Insert title here</title> <style type=\"text/css\"> .a {    width: 1px;   border: 1px white;   padding: 100px;    margin: 0px; } h1 { page-break-before: always; }   </style> </head> ";
		                  





























		                  responseString = responseString + JSPRelatedFunctionsimp.DuplicateCertificate(ValidatedFinalBean.getRollNo(), ValidatedFinalBean.getFatherName(), ValidatedFinalBean.getName(), ValidatedFinalBean.getEnrollmentDate(), ValidatedFinalBean.getEnrollmentRegistrationNo(), ValidatedFinalBean.getEnrollmentId());

		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("SearchWithKARNumberForStatusChange"))
		              {

		                String KARNumber = request.getParameter("KARNumber");
		                
		                System.out.println(KARNumber + "Jagga");
		                responseString = "   <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletFromJSP('" + KARNumber + "','KARStatusChange');\" >KAR Status Change</button>";
		                responseString = responseString + "</br></br>";
		                responseString = responseString + "   <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletFromJSP('" + KARNumber + "','ChangeOfAddress');\" >Change Of Address</button>";
		                responseString = responseString + "</br></br>";
		                responseString = responseString + "   <button name='ReSchedule' class='btn btn-info' onclick=\" CallToServletFromJSP('" + KARNumber + "','ChangeOfName');\" >Change Of Name</button>";



		              }
		               if (AjaxPage.equalsIgnoreCase("ScheduleInterviewWithDate"))
		              {
		                String RegNumber = request.getParameter("RegNumber");
		                String ScheduleDate = request.getParameter("SchedulingDate");
		                System.out.println("Date" + ScheduleDate);
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.ScheduleInterviewBydate(ScheduleDate, RegNumber);
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {
		                  responseString = "<h1>Interview For <b>" + RegNumber + "</b> this register number is schedulded please confirm the changes in Confirm Interview Tab.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("ConfirmTheScheduledInterview"))
		              {
		                String RegNumber = request.getParameter("KARNumber");
		                String ScheduleDate = request.getParameter("SchedulingDate");
		                System.out.println("Date" + ScheduleDate);
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.MoveToScheduleInterviewListFromConfirmationBean(RegNumber);
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {

		                  responseString = "<h1>Interview For <b>" + RegNumber + "</b> is confirmed and SMS and Mail is Sent.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("ConfirmTheScheduledInterviewAll"))
		              {

		                
		                String ScheduleResult = JSPRelatedFunctionsimp.MoveToScheduleInterviewListFromConfirmationBeanAll();
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {

		                  responseString = "<h1>Interview For is confirmed for all.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("AcceptAll"))
		              {
		                String RegNumber = request.getParameter("RegNumber");
		                
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.MoveToAbsentListFromScheduleListAll();
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {

		                  responseString = "<h1>Candidate, <b>" + RegNumber + "</b> is Moved to absent List.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";


		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("AbsentCandidateMoveTOAbsentList"))
		              {
		                String RegNumber = request.getParameter("KARNumber");
		                
		                System.out.println(RegNumber + "RegNumberAkshay");
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.MoveToAbsentListFromScheduleList(RegNumber);
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {

		                  responseString = "<h1>Candidate, <b>" + RegNumber + "</b> is Moved to absent List.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("DeclientheCandidate"))
		              {
		                String RegNumber = request.getParameter("KARNumber");
		                
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.DeclainTheCandidate(RegNumber);
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {

		                  responseString = "<h1>Candidate, <b>" + RegNumber + "</b> Deleted From the System.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("ReScheduletheAbsentCandidate"))
		              {
		                String RegNumber = request.getParameter("KARNumber");
		                System.out.println(RegNumber + "RegNumber");
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.ReScheduletheAbsentCandidate(RegNumber);
		                
		                System.out.println(ScheduleResult);
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {

		                  responseString = "<h1>Candidate, <b>" + RegNumber + "</b> Moved to eligible List.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                

		              }
		               if (AjaxPage.equalsIgnoreCase("AcceptTheCandidateMoveTOKAR"))
		              {
		                String RegNumber = request.getParameter("KARNumber");
		                
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.AcceptTheCandidateMoveTOKAR(RegNumber);
		                
		                if (ScheduleResult.equalsIgnoreCase("Failure"))
		                {

		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                else
		                {
		                  responseString = "<h1>Candidate, <b>" + ScheduleResult + "</b> KAR number is created.</h2>";

		                }
		                

		              }
		               if (AjaxPage.equalsIgnoreCase("KARStatusChange"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                
		                System.out.println(KARNumber);
		                responseString = "<form id='FormForViewChallan'   target='_blank'><input type='hidden' value='" + KARNumber + "'  name='KARNumber' id='KARNumber'><select id =\"KARStatus\" name=\"KARStatus\" class=\"form-control selectpicker\" ><option value=\" \" >Please select the Status of the KAR Number</option><option>Resume</option><option>Death</option><option >Declain</option></select></br></br><input type='button' class='btn btn-info' name='KARNumberChange' value='KARNumberChange'  id='KARNumberChange'  >\t</form> <script>     $('#KARNumberChange').click(function(event) { alert('********** KARNumberChange 2343 ***********');var KARStatus=$('#KARStatus').val();alert(KARStatus ); var KARNumber=$('#KARNumber').val(); alert(KARNumber);var WhichFunctionToHandle='UpdatetheKARStatus';alert(WhichFunctionToHandle);         $.get('AjaxServlet',{KARStatus:KARStatus,KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {   $('#Main_Content1').html(responseText);  });   });     </script> ";












































		              }
		               if (AjaxPage.equalsIgnoreCase("ChangeOfAddress"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                
		                System.out.println(KARNumber + " \t\t");
		                responseString = "<form id='FormForViewChallan'   target='_blank'><input type='hidden' value='" + KARNumber + "'  name='KARNumber' id='KARNumber'></br></br><textarea rows=\"4\" cols=\"50\" name='ChangeOfAddressTextArea' placeholder='ChangeOfAddress'  id='ChangeOfAddressTextArea' ></textarea></br></br><input type='text' name='remark' placeholder='Remarks'  id='remark'  ></br></br> <select name=\"StatusOfTheAdvocate\"  id=\"StatusOfTheAdvocate\">  <option>All</option> <option>  AFZALPUR </option><option>ALAND</option><option>ALUR</option><option>ANEKAL</option><option>ANKOLA</option><option>ARAKALGUD</option><option>ARASIKERE</option><option>ATHANI</option><option>AURAD</option><option>BADAMI</option><option>BAGALKOT</option><option>BAGEPALLI</option><option>BAILAHONGAL</option><option>BANAHATTI</option><option>BANGALORE</option><option>BANGARPET</option><option>BANTWAL</option><option>BASAVAKALYAN</option><option>BASAVANA BAGEWADI</option><option>BELGAUM</option><option>BELLARY</option><option>BELTHANGADY</option><option>BELUR</option><option>Bengaluru Rural</option><option>Bengaluru Urban</option><option>BHADRAVATHI</option><option>BHALKI</option><option>BHATKAL</option><option>BIDAR</option><option>BIJAPUR</option><option>BILAGI</option><option>BIRUR</option><option>BYADAGI</option><option>CB DHARWAD</option><option>CB Gulbarga</option><option>CHALLAKERE</option><option>CHAMARAJANAGAR</option><option>CHANNAGIRI</option><option>CHANNAPATNA</option><option>CHANNARAYAPATNA</option><option>CHIKBALLAPUR</option><option>Chikkaballapur</option><option>CHIKKAMAGALUR</option><option>Chikkamagaluru</option><option>CHIKKANAYANAKANAHALLI</option><option>CHIKODI</option><option>CHINCHOLI</option><option>CHINTAMANI</option><option>CHITRADURGA</option><option>CHITTAPUR</option><option>DANDELI</option><option>Davanagere</option><option>DAVANGERE</option><option>DEODURGA</option><option>DEVANAHALLI</option><option>DHARWAD</option><option>DODDABALLAPURA</option><option>GADAG</option><option>GANGAVATHI</option><option>GOKAK</option><option>GOWRIBIDANUR</option><option>GUBBI</option><option>GUDIBANDE</option><option>GULBARGA</option><option>GUNDLUPET</option><option>GUNTAKAL</option><option>HAGARI BOMMANAHALLI</option><option>HALIYAL</option><option>HANAGAL</option><option>HARAPANAHALLI</option><option>HARIHAR</option><option>HASSAN</option><option>HAVERI</option><option>HEGGADADEVANAKOTE</option><option>HIREKERUR</option><option>HIRIYUR</option><option>HOLALKERE</option><option>HOLENARSIPURA</option><option>HONNALI</option><option>HONNAVAR</option><option>HOSADURGA</option><option>HOSANAGARA</option><option>HOSKOTE</option><option>HOSPET</option><option>HUBLI</option><option>HUKKERI</option><option>HUMNABAD</option><option>HUNGUND</option><option>HUNSUR</option><option>HUVINAHADAGALI</option><option>ILKAL</option><option>INDI</option><option>JAGALUR</option><option>JAMKHANDI</option><option>JEWARGI</option><option>K  G   F</option><option>KADUR</option><option>Kalaburagi</option><option>KALAGHATGI</option><option>KALYANDURG</option><option>KANAKAPURA</option><option>KARKALA</option><option>KARWAR</option><option>KASARAGOD</option><option>KHANAPUR</option><option>KITTUR</option><option>Kodagu</option><option>KOLAR</option><option>KOLLEGAL</option><option>KOPPA</option><option>KOPPAL</option><option>KORATAGERE</option><option>KRISHNARAJA NAGARA</option><option>KRISHNARAJA PET</option><option>KUDLIGI</option><option>KUMTA</option><option>KUNDAGOL</option><option>KUNDAPURA</option><option>KUNIGAL</option><option>KUSHTAGI</option><option>LAXMESHWAR</option><option>LINGASUGUR</option><option>LUCKNOW</option><option>MACHALIPATNAM</option><option>MADDUR</option><option>MADHUGIRI</option><option>MADIKERI</option><option>MADURAI</option><option>MAGADI</option><option>MALAVALLI</option><option>MALUR</option><option>MANDYA</option><option>MANGALORE</option><option>MANVI</option><option>MOLAKALMURU</option><option>MOODBIDARI</option><option>MUDDEBIHAL</option><option>MUDHOL</option><option>MUDIGERE</option><option>MULBAGAL</option><option>MUNDAGOD</option><option>MUNDARGI</option><option>MYSORE</option><option>NAGAMANGALA</option><option>NANJANAGUD</option><option>NARASIMHA RAJA PURA</option><option>NARGUND</option><option>NAVALGUND</option><option>NELAMANGALA</option><option>NIPPANI</option><option>PALGHAT</option><option>PANDAVAPURA</option><option>PAVAGADA</option><option>PERIYAPATNA</option><option>PONNAMPET</option><option>PUTTUR</option><option>RABKAVI</option><option>RAIBAG</option><option>RAICHUR</option><option>Ramanagara</option><option>RAMANAGARAM</option><option>RAMDURG</option><option>RANEBENNUR</option><option>RON</option><option>SAGAR</option><option>SAKALESHPUR</option><option>SANDUR</option><option>SANKESHWAR</option><option>SAUNDATTI</option><option>SAVANUR</option><option>SEDAM</option><option>SHAHABAD</option><option>SHAHAPUR</option><option>SHIDLAGHATTA</option><option>SHIGGAON</option><option>SHIKARIPURA</option><option>SHIMOGA</option><option>SHIRAHATTI</option><option>SHIRALKOPPA</option><option>Shivamogga</option><option>SHORAPUR</option><option>SIDDAPURA</option><option>SINDAGI</option><option>SINDHANOOR</option><option>SIRA</option><option>SIRSI</option><option>SIRUGUPPA</option><option>SOMWARPET</option><option>SORABA</option><option>SRINGERI</option><option>SRINIVASAPURA</option><option>SRIRANGAPATNA</option><option>SULLIA</option><option>T.NARASIPURA</option><option>TARIKERE</option><option>THIRTHAHALLI</option><option>TIPTUR</option><option>TUMKUR</option><option>TURUVEKERE</option><option>UDUPI</option><option>Vijayapura</option><option>VIRAJPET</option><option>Yadgir</option><option>YADGIRI</option><option>YELANDUR</option><option>YELBURGA</option><option>YELLAPUR</option></select><input type='button' class='btn btn-info' name='ChangeOfAddressButton' value='Change the Address'  id='ChangeOfAddressButton'  >\t</form> <script>     $('#ChangeOfAddressButton').click(function(event) { alert('********** ChangeOfAddressButton ***********'); var KARNumber=$('#KARNumber').val(); var remark=$('#remark').val();alert(KARNumber);var StatusOfTheAdvocate=$('#StatusOfTheAdvocate').val();var WhichFunctionToHandle='ChangeOFAdressForKarNumber'; var ChangeOfAddressTextArea=$('#ChangeOfAddressTextArea').val(); alert(ChangeOfAddressTextArea);alert(WhichFunctionToHandle);var Remarks=$('#Remarks').val();          $.get('AjaxServlet',{StatusOfTheAdvocate:StatusOfTheAdvocate,remark:remark,ChangeOfAddressTextArea:ChangeOfAddressTextArea,KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {   $('#Main_Content1').html(responseText);  });   });     </script> ";





































































































































































































































































		              }
		               if (AjaxPage.equalsIgnoreCase("ChangeOFAdressForKarNumber"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                String Address = request.getParameter("ChangeOfAddressTextArea");
		                String Remarks = request.getParameter("remark");
		                String StatusOfTheAdvocate = request.getParameter("StatusOfTheAdvocate");
		                
		                System.out.println(KARNumber);
		                System.out.println(Remarks);
		                System.out.println(Address);
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.ChangeAddressInEnrollment(KARNumber, Address, Remarks, StatusOfTheAdvocate);
		                if (ScheduleResult.equalsIgnoreCase("Sucessfully Updated"))
		                {

		                  responseString = "<h1>Candidate Address is Successfully updated.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                

		              }
		               if (AjaxPage.equalsIgnoreCase("ChangeOFNameForKarNumber"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                String ChangeOfNameText = request.getParameter("ChangeOfNameText");
		                
		                String remarks = request.getParameter("remarks");
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.ChangeTheEnrollmentName(KARNumber, ChangeOfNameText, remarks);
		                if (ScheduleResult.equalsIgnoreCase("Sucessfully Updated"))
		                {

		                  responseString = "<h1>Candidate Name is Successfully updated.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                


		              }
		               if (AjaxPage.equalsIgnoreCase("ChangeOfName"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                

		                responseString = "<form id='FormForViewChallan'   target='_blank'><input type='hidden' value='" + KARNumber + "'  name='KARNumber' id='KARNumber'> <input type='text' class=\"form-control\"  id=\"ChangeOfNameText\"> <input type='text' placeholder='Remarks' id=\"Remark\"></br></br><input type='button' class='btn btn-info' name='ChangeOfNameButton' value='Change the Name'  id='ChangeOfNameButton'  >\t</form> <script>     $('#ChangeOfNameButton').click(function(event) { alert('********** ChangeOfNameButton ***********'); var KARNumber=$('#KARNumber').val(); var remarks=$('#Remark').val(); var WhichFunctionToHandle='ChangeOFNameForKarNumber'; var ChangeOfNameText=$('#ChangeOfNameText').val(); alert(ChangeOfNameText);alert(WhichFunctionToHandle);         $.get('AjaxServlet',{remarks:remarks,ChangeOfNameText:ChangeOfNameText,KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {   $('#Main_Content1').html(responseText);  });   });     </script> ";



		              }
		               if (AjaxPage.equalsIgnoreCase("SearchWithKARNumberForNomineeChange"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                

		                responseString = "<form id='FormForViewChallan'   target='_blank'><input type='hidden' value='" + KARNumber + "'  name='KARNumber' id='KARNumber'> <textarea class=\"form-control\" rows=\"5\" id=\"ChangeOfNomineeTextArea\"></textarea></br></br><input type='button' class='btn btn-info' name='ChangeOfNomineeButton' value='Change the Nominee'  id='ChangeOfNomineeButton'  >\t</form> <script>     $('#ChangeOfNomineeButton').click(function(event) { alert('********** ChangeOfNomineeButton ***********'); var KARNumber=KARNumber; var WhichFunctionToHandle='ChangeOFNomineeForKarNumber'; var ChangeOfNomineeTextArea=$('#ChangeOfNomineeTextArea').val(); alert(ChangeOfNomineeTextArea);alert(WhichFunctionToHandle);         $.get('AjaxServlet',{ChangeOfNomineeTextArea:ChangeOfNomineeTextArea,KARNumber:KARNumber,WhichFunctionToHandle:WhichFunctionToHandle},function(responseText) {   $('#Main_Content1').html(responseText);  });   });     </script> ";


		              }
		               if (AjaxPage.equalsIgnoreCase("ChangeOFNomineeForKarNumber"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                String ChangeOfNomineeTextArea = request.getParameter("ChangeOfNomineeTextArea");
		                
		                String ScheduleResult = JSPRelatedFunctionsimp.UpdateNomineeOfKARnumber(KARNumber, ChangeOfNomineeTextArea);
		                if (ScheduleResult.equalsIgnoreCase("Success"))
		                {

		                  responseString = "<h1>Candidate Nominee is Successfully updated.</h2>";
		                }
		                else
		                {
		                  responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                }
		                

		              }
		               if (AjaxPage.equalsIgnoreCase("SelectForChangesPay"))
		              {
		                String KARNumber = request.getParameter("KARNumber");
		                String PayForWelfareSelect = request.getParameter("PaySelect");
		                System.out.println(PayForWelfareSelect + "  Cha");
		                

		                
		                double ValueTobePayed = JSPRelatedFunctionsimp.GetAmountForWelfareSelect(KARNumber, PayForWelfareSelect);
		                System.out.println(ValueTobePayed);

		              }
		               if (AjaxPage.equalsIgnoreCase("SelectForWelfareChangesPay"))
		              {


		                String KARNumber = request.getParameter("KARNumber");
		                String PayForWelfareSelect = request.getParameter("PaySelect");
		                System.out.println(PayForWelfareSelect + "  *********");
		                
		                
		                double ValueTobePayed = JSPRelatedFunctionsimp.GetAmountForWelfareSelect(KARNumber, PayForWelfareSelect);
		                System.out.println(ValueTobePayed);


		              }
		               if (AjaxPage.equalsIgnoreCase("SelectForChallanUpload"))
		              {

		                String KARNumber = (String)Session.getAttribute("KARNumber");
		                Session.setAttribute("KARNumber", KARNumber);
		                System.out.println(KARNumber + "    ********************         ffffff");
		                request.setAttribute("KARNumber", KARNumber);
		                String PayForWelfareSelect = request.getParameter("PaySelect");
		                System.out.println(PayForWelfareSelect + "  *********");
		                Session.setAttribute("WhichChallan", PayForWelfareSelect);
		                
		                double ValueTobePayed = JSPRelatedFunctionsimp.GetAmountForWelfareSelect(KARNumber, PayForWelfareSelect);
		                System.out.println(ValueTobePayed);
		                
		                responseString = "<form action='UploadServletForChallan' method='post' enctype='multipart/form-data'><div class='form-group'> <label class='col-md-4 control-label'>Upload your Challan Copy (Must not more then 500KB only jpg and png is allowed)</label>  <div class='col-md-4 inputGroupContainer'>  <div class='input-group'>   <span class='input-group-addon'><i class='glyphicon glyphicon-user'></i></span>   <input type='file' name='ChallanFile' size='50' /> </br></br>   <button type='submit' class='btn btn-warning'>Next Step <span class='glyphicon glyphicon-send'></span></button> </div>  </div>  </div> </form>";

 }
		               if (!AjaxPage.equalsIgnoreCase("ViewChallanForKARPayment"))
		              {






		              }




		                if (AjaxPage.equalsIgnoreCase("EditConfirmList"))
		                {
		                  System.out.println("coming HERE EditConfirmList");
		                  
		                  String renumber = request.getParameter("KARNumber");
		                  
		                  System.out.println(renumber + "   renumber");
		                  HttpSession Servletsession = request.getSession(false);
		                  if (Servletsession == null)
		                  {
		                    Servletsession = request.getSession(true);
		                  }
		                  
		                  ScheduleConfirmationBean con = JSPRelatedFunctionsimp.GetConfirmBean(renumber);
		                  if (con == null)
		                  {

		                    System.out.println("null coming");
		                    Servletsession.setAttribute("REGnumber", "");
		                    Servletsession.setAttribute("Name", "");
		                    Servletsession.setAttribute("father", "");
		                  }
		                  else
		                  {
		                    System.out.println("null not coming");
		                    System.out.println("null not coming  " + con.getFather_name());
		                    Servletsession.setAttribute("REGnumber", con.getRegNumber());
		                    Servletsession.setAttribute("Name", con.getFullName());
		                    
		                    Servletsession.setAttribute("ImageURL", "ImageServlet?RegNumber=" + renumber + "&WhichPhoto=Photo");
		                    Servletsession.setAttribute("father", con.getFather_name());
		                  }
		                  

		                  response.sendRedirect("EditConfirmList.jsp");



		                }
		                 if (AjaxPage.equalsIgnoreCase("GetConfirmationDetails"))
		                {
		                  System.out.println("coming HERE GetConfirmationDetails");
		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  System.out.println(KARNumber + "KARNumber");
		                  
		                  
		                  ScheduleConfirmationBean ValidatedFinalBean = JSPRelatedFunctionsimp.GetKARNumberInfoForCertificateConfirmList(KARNumber);
		                  responseString = ValidatedFinalBean.getFullName() + "div" + ValidatedFinalBean.getFather_name() + "div" + ValidatedFinalBean.getEmail() + "div" + ValidatedFinalBean.getAddress() + "div" + ValidatedFinalBean.getPhone() + "div" + ValidatedFinalBean.getCity() + "div" + ValidatedFinalBean.getZipCode();





		                }
		                 if (AjaxPage.equalsIgnoreCase("GetReportForTappalInworld"))
		                {
		                  System.out.println("coming HERE GetConfirmationDetails");
		                  String KARNumber = request.getParameter("INworldID");
		                  

		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GetDetailsForInWorldTappal(KARNumber);




		                }
		                 if (AjaxPage.equalsIgnoreCase("GetReportForTappalInworldComplaint"))
		                {
		                  System.out.println("coming HERE GetConfirmationDetails");
		                  String KARNumber = request.getParameter("INworldID");
		                  

		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GetDetailsForInWorldComplaintTappal(KARNumber);




		                }
		                 if (AjaxPage.equalsIgnoreCase("GetReportForTappalAssertworld"))
		                {
		                  System.out.println("coming HERE GetConfirmationDetails");
		                  String KARNumber = request.getParameter("INworldID");
		                  

		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GetDetailsForTappalAssert(KARNumber);



		                }
		                 if (AjaxPage.equalsIgnoreCase("GetReportForTappalOutworld"))
		                {
		                  System.out.println("coming HERE GetConfirmationDetails");
		                  String KARNumber = request.getParameter("INworldID");
		                  

		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GetDetailsForOutWorldTappal(KARNumber);




		                }
		                 if (AjaxPage.equalsIgnoreCase("ConfirmChallanForKARPayment"))
		                {

		                  EligibleKARChanges EligibleKARChanges = new EligibleKARChanges();
		                  EligibleKARChanges.setKARNumber(request.getParameter("KARNumber"));
		                  EligibleKARChanges.setPayingFor(request.getParameter("payingForDetails"));
		                  String RegNumber = request.getParameter("KARNumber");
		                  System.out.println(request.getParameter("KARNumber"));
		                  AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                  String ResultOfMovingToverfiedBean = AccountJSPRelatedFunctionsImp.MoveToEligibleKARChangesconfirmBean(EligibleKARChanges);
		                  responseString = ResultOfMovingToverfiedBean;



		                }
		                 if (AjaxPage.equalsIgnoreCase("ConfirmChallanForKARPayment"))
		                {

		                  EligibleKARChanges EligibleKARChanges = new EligibleKARChanges();
		                  EligibleKARChanges.setKARNumber(request.getParameter("KARNumber"));
		                  EligibleKARChanges.setPayingFor(request.getParameter("payingForDetails"));
		                  String RegNumber = request.getParameter("KARNumber");
		                  System.out.println(request.getParameter("KARNumber"));
		                  AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                  String ResultOfMovingToverfiedBean = AccountJSPRelatedFunctionsImp.MoveToEligibleKARChangesconfirmBean(EligibleKARChanges);
		                  responseString = ResultOfMovingToverfiedBean;



		                }
		                 if (AjaxPage.equalsIgnoreCase("WorkIsDoneForKARChanges"))
		                {

		                  EligibleKARChanges EligibleKARChanges = new EligibleKARChanges();
		                  EligibleKARChanges.setKARNumber(request.getParameter("KARNumber"));
		                  EligibleKARChanges.setPayingFor(request.getParameter("payingForDetails"));
		                  String RegNumber = request.getParameter("KARNumber");
		                  System.out.println(request.getParameter("KARNumber"));
		                  AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                  String ResultOfMovingToverfiedBean = AccountJSPRelatedFunctionsImp.SaveEligibleKARChangesconfirmBean(EligibleKARChanges);
		                  responseString = ResultOfMovingToverfiedBean;


		                }
		                 if (AjaxPage.equalsIgnoreCase("UpdatetheKARStatus"))
		                {

		                  System.out.println("   ****************8 UpdatetheKARStatus ********************");
		                  
		                  
		                  String KARStatus = request.getParameter("KARStatus");
		                  String KARNumber = request.getParameter("KARNumber");
		                  String ResultOfStatusUpdate = JSPRelatedFunctionsimp.UpdateStatusOfKARnumber(KARNumber, KARNumber);
		                  







		                  if (ResultOfStatusUpdate.equalsIgnoreCase("Success"))
		                  {

		                    responseString = "<h1>Candidate Staus is Successfully updated.</h2>";
		                  }
		                  else
		                  {
		                    responseString = "<h1>Sorry Something Went Wrong.. Please try again later</h2>";

		                  }
		                  


		                }
		                 if (AjaxPage.equalsIgnoreCase("DOBImageLoad"))
		                {
		                  String REGNumber = request.getParameter("REGNumber");
		                  String WhichPhoto = request.getParameter("WhichPhoto");
		                  responseString = "<img alt=\"Image\" src=\"ImageServlet?RegNumber=" + REGNumber + "&WhichPhoto=" + WhichPhoto + "\">";



		                }
		                 if (AjaxPage.equalsIgnoreCase("ChallanScanedCopyLoad"))
		                {

		                  String REGNumber = request.getParameter("REGNumber");
		                  String WhichPhoto = request.getParameter("WhichPhoto");
		                  responseString = "<img alt=\"Image\" src=\"ImageServlet?RegNumber=" + REGNumber + "&WhichPhoto=" + WhichPhoto + "\">";



		                }
		                 if (AjaxPage.equalsIgnoreCase("PhotoLoad"))
		                {
		                  String REGNumber = request.getParameter("REGNumber");
		                  String WhichPhoto = request.getParameter("WhichPhoto");
		                  responseString = "<img alt=\"Image\" src=\"ImageServlet?RegNumber=" + REGNumber + "&WhichPhoto=" + WhichPhoto + "\">";



		                }
		                 if (AjaxPage.equalsIgnoreCase("LifeTimeMembershipReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    try {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                    
		                    ArrayList<LifeTimeMembership> LifeTimeMemberArrayList = AccountJSPRelatedFunctionsImp.GetAllLifeTimeMembershipFromDates(StartDateSQLdate, EndDateSQLdate);
		                    if (LifeTimeMemberArrayList == null)
		                    {

		                      String HTMLContent = "Something Went Wrong";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                      String HTMLContent = "<!DOCTYPE html><html><head>\t<title></title></head><body><h2>Report For Generate Report</h2><h3>From " + StartDate + " to " + EndDate + "</h3></br></br><table class='table table-striped'><thead><tr><th>#</th><th>KAR Number</th><th>Method Of Payment</th><th>Paying For</th><th>Payed Date</th></tr> </thead><tbody>";
		                      














		                      int index = 0;
		                      for (LifeTimeMembership validatedFinalBean : LifeTimeMemberArrayList)
		                      {







		                        HTMLContent = HTMLContent + " <tr> <th scope='row'>" + index + "</th>  <td>" + validatedFinalBean.getSerialNumber() + "</td> <td>" + validatedFinalBean.getKARNumber() + "</td>  <td>" + validatedFinalBean.getMethodOfPayment() + "</td>  <td>" + validatedFinalBean.getPayingFor() + "</td> <td>" + validatedFinalBean.getPayedDate() + "</td> </tr>";
		                        


		                        index++;
		                      }
		                      HTMLContent = HTMLContent + " </tbody> </table></body></html>";
		                    }
		                    




		                    responseString = "<input type='button' class='btn btn-info' name='SearchWithKARNumberForCertificate' value='Download Certificate'  id='SearchWithKARNumberForCertificate'  >";
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";
		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("ThousandrupeespayedMembershipReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    try {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                    
		                    ArrayList<ThousandPayedAdvocateBean> LifeTimeMemberArrayList = AccountJSPRelatedFunctionsImp.GetAllThousandPayedAdvocateFromDates(StartDateSQLdate, EndDateSQLdate);
		                    if (LifeTimeMemberArrayList == null)
		                    {
		                      String HTMLContent = "Something Went Wrong";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                      String HTMLContent = "<!DOCTYPE html><html><head>\t<title></title></head><body><h2>Report For Generate Report</h2><h3>From " + StartDate + " to " + EndDate + "</h3></br></br><table class='table table-striped'><thead><tr><th>#</th><th>KAR Number</th><th>Method Of Payment</th><th>Paying For</th><th>Payed Date</th></tr> </thead><tbody>";
		                      














		                      int index = 0;
		                      for (ThousandPayedAdvocateBean validatedFinalBean : LifeTimeMemberArrayList)
		                      {







		                        HTMLContent = HTMLContent + " <tr> <th scope='row'>" + index + "</th>  <td>" + validatedFinalBean.getSerialNumber() + "</td> <td>" + validatedFinalBean.getKARNumber() + "</td>  <td>" + validatedFinalBean.getMethodOfPayment() + "</td>  <td>" + validatedFinalBean.getPayingFor() + "</td> <td>" + validatedFinalBean.getPayedDate() + "</td> </tr>";
		                        


		                        index++;
		                      }
		                      HTMLContent = HTMLContent + " </tbody> </table></body></html>";
		                    }
		                    



		                    responseString = "<input type='button' class='btn btn-info' name='SearchWithKARNumberForCertificate' value='Download Certificate'  id='SearchWithKARNumberForCertificate'  >";
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";
		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("FiveHundreadrupeespayedMembershipReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                    
		                    ArrayList<FiveHundreadPayedAdvocateBean> LifeTimeMemberArrayList = AccountJSPRelatedFunctionsImp.GetAllFiveHundreadPayedAdvocateFromDates(StartDateSQLdate, EndDateSQLdate);
		                    if (LifeTimeMemberArrayList == null)
		                    {
		                      String HTMLContent = "Something Went Wrong";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                      String HTMLContent = "<!DOCTYPE html><html><head>\t<title></title></head><body><h2>Report For Generate Report</h2><h3>From " + StartDate + " to " + EndDate + "</h3></br></br><table class='table table-striped'><thead><tr><th>#</th><th>KAR Number</th><th>Method Of Payment</th><th>Paying For</th><th>Payed Date</th></tr> </thead><tbody>";
		                      














		                      int index = 0;
		                      for (FiveHundreadPayedAdvocateBean validatedFinalBean : LifeTimeMemberArrayList)
		                      {







		                        HTMLContent = HTMLContent + " <tr> <th scope='row'>" + index + "</th>  <td>" + validatedFinalBean.getSerialNumber() + "</td> <td>" + validatedFinalBean.getKARNumber() + "</td>  <td>" + validatedFinalBean.getMethodOfPayment() + "</td>  <td>" + validatedFinalBean.getPayingFor() + "</td> <td>" + validatedFinalBean.getPayedDate() + "</td> </tr>";
		                        


		                        index++;
		                      }
		                      HTMLContent = HTMLContent + " </tbody> </table></body></html>";
		                    }
		                    



		                    responseString = "<input type='button' class='btn btn-info' name='SearchWithKARNumberForCertificate' value='Download Certificate'  id='SearchWithKARNumberForCertificate'  >";
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";
		                  }
		                  
		                }
		                 if (AjaxPage.equalsIgnoreCase("NomineeChangeReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                    
		                    ArrayList<EligibleKARChangesConfirm> LifeTimeMemberArrayList = AccountJSPRelatedFunctionsImp.GetAllNomineeKARChangesConfirmFromDates(StartDateSQLdate, EndDateSQLdate);
		                    
		                    if (LifeTimeMemberArrayList == null)
		                    {
		                      String HTMLContent = "Sorry Something Went Wrong";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                      String HTMLContent = "<!DOCTYPE html><html><head>\t<title></title></head><body><h2>Report For Generate Report</h2><h3>From " + StartDate + " to " + EndDate + "</h3></br></br><table class='table table-striped'><thead><tr><th>#</th><th>KAR Number</th>><th>Paying For</th><th>Payed Date</th></tr> </thead><tbody>";
		                      














		                      int index = 0;
		                      for (EligibleKARChangesConfirm validatedFinalBean : LifeTimeMemberArrayList)
		                      {







		                        HTMLContent = HTMLContent + " <tr> <th scope='row'>" + index + "</th>  <td>" + validatedFinalBean.getSerialNumber() + "</td> <td>" + validatedFinalBean.getKARNumber() + "</td>  <td>" + validatedFinalBean.getPayingFor() + "</td> <td>" + validatedFinalBean.getRequestCompletedDate() + "</td> </tr>";
		                        


		                        index++;
		                      }
		                      HTMLContent = HTMLContent + " </tbody> </table></body></html>";
		                    }
		                    




		                    responseString = "<input type='button' class='btn btn-info' name='SearchWithKARNumberForCertificate' value='Download Certificate'  id='SearchWithKARNumberForCertificate'  >";
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";
		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("RetiredAdvocateReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    
		                    
		                    ArrayList<ValidatedFinalBean> LifeTimeMemberArrayList = JSPRelatedFunctionsimp.ViewFinalKARNumberForDeathCandidate("Death", StartDateSQLdate, EndDateSQLdate);
		                    if (LifeTimeMemberArrayList == null)
		                    {
		                      String HTMLContent = "Sorry Something Went Wrong";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                      String HTMLContent = "<!DOCTYPE html><html><head>\t<title></title></head><body><h2>Report For Generate Report</h2><h3>From " + StartDate + " to " + EndDate + "</h3></br></br><table class='table table-striped'><thead><tr><th>#</th><th>KAR Number</th>><th>Full Name</th><th>Address</th><th>City</th><th>Email</th><th>GenderCategory</th><th>PlaceOfPractice</th><th>Type Of Report</th></tr> </thead><tbody>";
		                      















		                      int index = 0;
		                      for (ValidatedFinalBean validatedFinalBean : LifeTimeMemberArrayList)
		                      {









		                        HTMLContent = HTMLContent + " <tr> <th scope='row'>" + index + "</th> <td>" + index + "</td> <td>" + validatedFinalBean.getKARNumber() + "</td> <td>" + validatedFinalBean.getFullName() + "</td> <td>" + validatedFinalBean.getAddress() + "</td> <td>" + validatedFinalBean.getCity() + "</td> <td>" + validatedFinalBean.getEmail() + "</td> <td>" + validatedFinalBean.getGenderCategory() + "</td> <td>" + validatedFinalBean.getPlaceOfPractice() + "</td>  <td>Ritired</td> </tr>";
		                        






		                        index++;
		                      }
		                      HTMLContent = HTMLContent + " </tbody> </table></body></html>";
		                    }
		                    





		                    responseString = "<input type='button' class='btn btn-info' name='SearchWithKARNumberForCertificate' value='Download Certificate'  id='SearchWithKARNumberForCertificate'  >";
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";

		                  }
		                  


		                }
		                 if (AjaxPage.equalsIgnoreCase("LateAdvocateReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    
		                    
		                    ArrayList<ValidatedFinalBean> LifeTimeMemberArrayList = JSPRelatedFunctionsimp.ViewFinalKARNumberForDeathCandidate("Retired", StartDateSQLdate, EndDateSQLdate);
		                    
		                    if (LifeTimeMemberArrayList == null)
		                    {
		                      String HTMLContent = "Sorry Something Went Wrong";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                      String HTMLContent = "<!DOCTYPE html><html><head>\t<title></title></head><body><h2>Report For Generate Report</h2><h3>From " + StartDate + " to " + EndDate + "</h3></br></br><table class='table table-striped'><thead><tr><th>#</th><th>KAR Number</th>><th>Full Name</th><th>Address</th><th>City</th><th>Email</th><th>GenderCategory</th><th>PlaceOfPractice</th><th>Type Of Report</th></tr> </thead><tbody>";
		                      















		                      int index = 0;
		                      for (ValidatedFinalBean validatedFinalBean : LifeTimeMemberArrayList)
		                      {









		                        HTMLContent = HTMLContent + " <tr> <th scope='row'>" + index + "</th> <td>" + index + "</td> <td>" + validatedFinalBean.getKARNumber() + "</td> <td>" + validatedFinalBean.getFullName() + "</td> <td>" + validatedFinalBean.getAddress() + "</td> <td>" + validatedFinalBean.getCity() + "</td> <td>" + validatedFinalBean.getEmail() + "</td> <td>" + validatedFinalBean.getGenderCategory() + "</td> <td>" + validatedFinalBean.getPlaceOfPractice() + "</td>  <td>Ritired</td> </tr>";
		                        






		                        index++;
		                      }
		                      HTMLContent = HTMLContent + " </tbody> </table></body></html>";
		                    }
		                    





		                    responseString = "<input type='button' class='btn btn-info' name='SearchWithKARNumberForCertificate' value='Download Certificate'  id='SearchWithKARNumberForCertificate'  >";
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";

		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("AdmissionReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    String PlaceOfPractice = request.getParameter("PlaceOfPractice");
		                    String CastCategory = request.getParameter("CastCategory");
		                    String GenderCategory = request.getParameter("GenderCategory");
		                    
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    
		                    
		                    String LifeTimeMemberArrayList = JSPRelatedFunctionsimp.GenerateAdmissionReport(PlaceOfPractice, StartDateSQLdate, EndDateSQLdate, CastCategory, GenderCategory);
		                    if (LifeTimeMemberArrayList == null)
		                    {
		                      System.out.println("There is not data");
		                      responseString = "Sorry there is no data";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                    }
		                    

		                    responseString = "<input type='button' class='btn btn-info' name='SearchWithKARNumberForCertificate' value='Download Certificate'  id='SearchWithKARNumberForCertificate'  >";
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";
		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("GenerateReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    String StatusOfTheAdvocate = request.getParameter("StatusOfTheAdvocate");
		                    String CastCategory = request.getParameter("CastCategory");
		                    String GenderCategory = request.getParameter("GenderCategory");
		                    
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    
		                    
		                    responseString = JSPRelatedFunctionsimp.GenerateAdmissionReport(StatusOfTheAdvocate, StartDateSQLdate, EndDateSQLdate, CastCategory, GenderCategory);
		                    System.out.println(responseString);
		                    if (responseString == null)
		                    {
		                      System.out.println("There is not data");
		                      responseString = "Sorry there is no data";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                    }
		                    

		                  }
		                  catch (Exception e)
		                  {

		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";

		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("GeneralReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    String PlaceOfPractice = request.getParameter("PlaceOfPractice");
		                    String CastCategory = request.getParameter("CastCategory");
		                    String GenderCategory = request.getParameter("GenderCategory");
		                    
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    
		                    
		                    String LifeTimeMemberArrayList = JSPRelatedFunctionsimp.GenerateAdmissionReport(PlaceOfPractice, StartDateSQLdate, EndDateSQLdate, CastCategory, GenderCategory);
		                    if (LifeTimeMemberArrayList == null)
		                    {
		                      System.out.println("There is not data");
		                      responseString = "Sorry there is no data";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                    }
		                    

		                  }
		                  catch (Exception e)
		                  {

		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";

		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("ElectionGenerateReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    String StatusOfTheAdvocate = request.getParameter("StatusOfTheAdvocate");
		                    String CastCategory = request.getParameter("CastCategory");
		                    String GenderCategory = request.getParameter("GenderCategory");
		                    
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    


		                    
		                    
		                    responseString = JSPRelatedFunctionsimp.GenerateElectionReport(StatusOfTheAdvocate, CastCategory, GenderCategory);
		                    System.out.println(responseString);
		                    if (responseString == null)
		                    {
		                      System.out.println("There is not data");
		                      responseString = "Sorry there is no data";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                    }
		                    

		                  }
		                  catch (Exception e)
		                  {

		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";

		                  }
		                  


		                }
		                 if (AjaxPage.equalsIgnoreCase("GenerateReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    String StatusOfTheAdvocate = request.getParameter("StatusOfTheAdvocate");
		                    String CastCategory = request.getParameter("CastCategory");
		                    String GenderCategory = request.getParameter("GenderCategory");
		                    
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    
		                    
		                    responseString = JSPRelatedFunctionsimp.GenerateAdmissionReport(StatusOfTheAdvocate, StartDateSQLdate, EndDateSQLdate, CastCategory, GenderCategory);
		                    System.out.println(responseString);
		                    if (responseString == null)
		                    {
		                      System.out.println("There is not data");
		                      responseString = "Sorry there is no data";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                    }
		                    

		                  }
		                  catch (Exception e)
		                  {

		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";


		                  }
		                  


		                }
		                 if (AjaxPage.equalsIgnoreCase("OutGoingReport"))
		                {

		                  try
		                  {
		                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                    String StartDate = request.getParameter("StartDate");
		                    String EndDate = request.getParameter("EndDate");
		                    String StatusOfTheAdvocate = request.getParameter("StatusOfTheAdvocate");
		                    String CastCategory = request.getParameter("CastCategory");
		                    String GenderCategory = request.getParameter("GenderCategory");
		                    
		                    java.util.Date parsedStartDate = null;
		                    java.util.Date parsedEndDate = null;
		                    java.sql.Date StartDateSQLdate = null;
		                    java.sql.Date EndDateSQLdate = null;
		                    
		                    try
		                    {
		                      parsedStartDate = format.parse(StartDate);
		                      parsedEndDate = format.parse(EndDate);
		                      StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                      EndDateSQLdate = new java.sql.Date(parsedEndDate.getTime());
		                    }
		                    catch (ParseException e) {
		                      e.printStackTrace();
		                    }
		                    
		                    
		                    responseString = JSPRelatedFunctionsimp.GenerateIncomingReport(StatusOfTheAdvocate, StartDateSQLdate, EndDateSQLdate, CastCategory, GenderCategory);
		                    System.out.println(responseString);
		                    if (responseString == null)
		                    {
		                      System.out.println("There is not data");
		                      responseString = "Sorry there is no data";
		                      System.out.println("Coming to HTMLContent if part");
		                    }
		                    else
		                    {
		                      System.out.println("Coming to else if part");
		                    }
		                    

		                  }
		                  catch (Exception e)
		                  {

		                    e.printStackTrace();
		                    responseString = "Sorry Something Went Wrong";

		                  }
		                  

		                }
		                 if (AjaxPage.equalsIgnoreCase("ChallanScanedCopyLoadForKAR"))
		                {

		                  String KARNumber = request.getParameter("KARNumber");
		                  String WhichPhoto = request.getParameter("WhichPhoto");
		                  responseString = "<img alt=\"Image\" src=\"KARNumberImageServlet?KARNumber=" + KARNumber + "&WhichPhoto=" + WhichPhoto + "\">";




		                }
		                 if (AjaxPage.equalsIgnoreCase("KARLoginUsingName"))
		                {

		                  HttpSession Servletsession = request.getSession(false);
		                  if (Servletsession == null)
		                  {
		                    Servletsession = request.getSession(true);
		                  }
		                  
		                  String Name = request.getParameter("Name");
		                  String Place = request.getParameter("Place");
		                  
		                  responseString = JSPRelatedFunctionsimp.GetEnrollmentDetailsByName(Name, Place);








		                }
		                 if (AjaxPage.equalsIgnoreCase("FeeStructureForKAR"))
		                {
		                  System.out.println("HI FeeStructure");
		                  HashMap<String, Integer> mapChallanScannedCopy = new HashMap();
		                  
		                  Integer EnrollmentFee = Integer.valueOf(Integer.parseInt(request.getParameter("EnrollmentFee")));
		                  Integer ReimbursementOFSalaryDeduction = Integer.valueOf(Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction")));
		                  Integer ClosingFD = Integer.valueOf(Integer.parseInt(request.getParameter("ClosingFD")));
		                  Integer KSBCCostReceipt = Integer.valueOf(Integer.parseInt(request.getParameter("KSBCCostReceipt")));
		                  Integer ElectionRules = Integer.valueOf(Integer.parseInt(request.getParameter("ElectionRules")));
		                  Integer NominationForm = Integer.valueOf(Integer.parseInt(request.getParameter("NominationForm")));
		                  Integer VoterCD = Integer.valueOf(Integer.parseInt(request.getParameter("VoterCD")));
		                  Integer ElectionDeposit = Integer.valueOf(Integer.parseInt(request.getParameter("ElectionDeposit")));
		                  Integer PDC = Integer.valueOf(Integer.parseInt(request.getParameter("PDC")));
		                  Integer DOBCertificate = Integer.valueOf(Integer.parseInt(request.getParameter("DOBCertificate")));
		                  Integer CertificateCopyCharges = Integer.valueOf(Integer.parseInt(request.getParameter("CertificateCopyCharges")));
		                  Integer PostageReceipts = Integer.valueOf(Integer.parseInt(request.getParameter("PostageReceipts")));
		                  String KARNumber = request.getParameter("KARNumber");
		                  Integer DuplicateEnrollment = Integer.valueOf(Integer.parseInt(request.getParameter("DuplicateEnrollemt")));
		                  

		                  Integer EndomentCertificate = Integer.valueOf(Integer.parseInt(request.getParameter("EndomentCertificate")));
		                  Integer KSBCInterestONFD = Integer.valueOf(Integer.parseInt(request.getParameter("KSBCInterestONFD")));
		                  String PlaceOftheClient = request.getParameter("PlaceOftheClient");
		                  Integer EnrollmentApplication = Integer.valueOf(Integer.parseInt(request.getParameter("EnrollmentApplication")));
		                  Integer IdentityCard = Integer.valueOf(Integer.parseInt(request.getParameter("IdentityCard")));
		                  String NameOftheClient = request.getParameter("NameOftheClient");
		                  Integer ComplaintFee = Integer.valueOf(Integer.parseInt(request.getParameter("ComplaintFee")));
		                  Integer ChangeOfAddress = Integer.valueOf(Integer.parseInt(request.getParameter("ChangeOfAddress")));
		                  Integer ContinuityCertificate = Integer.valueOf(Integer.parseInt(request.getParameter("ContinuityCertificate")));
		                  Integer VSP = Integer.valueOf(Integer.parseInt(request.getParameter("VSP")));
		                  Integer ProcessFee = Integer.valueOf(Integer.parseInt(request.getParameter("ProcessFee")));
		                  Integer miscReceipts = Integer.valueOf(Integer.parseInt(request.getParameter("MiscReceipts")));
		                  
		                  Integer NOC = Integer.valueOf(Integer.parseInt(request.getParameter("NOC")));
		                  Integer ChangeOfNamePublication = Integer.valueOf(Integer.parseInt(request.getParameter("ChangeOfNamePublication")));
		                  Integer endomentCertificate = Integer.valueOf(Integer.parseInt(request.getParameter("EndomentCertificate")));
		                  Integer reimbursementOFSalaryDeduction = Integer.valueOf(Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction")));
		                  
		                  Integer enrollmentApplication = Integer.valueOf(Integer.parseInt(request.getParameter("EnrollmentApplication")));
		                  

		                  Integer total = Integer.valueOf(EnrollmentFee.intValue() + ReimbursementOFSalaryDeduction.intValue() + ClosingFD.intValue() + KSBCCostReceipt.intValue() + ElectionRules.intValue());
		                  total = Integer.valueOf(total.intValue() + (NominationForm.intValue() + VoterCD.intValue() + ElectionDeposit.intValue() + PDC.intValue() + DOBCertificate.intValue() + PostageReceipts.intValue() + DuplicateEnrollment.intValue() + EndomentCertificate.intValue()));
		                  total = Integer.valueOf(total.intValue() + (KSBCInterestONFD.intValue() + EnrollmentApplication.intValue() + IdentityCard.intValue() + ComplaintFee.intValue() + ChangeOfAddress.intValue() + ContinuityCertificate.intValue()));
		                  total = Integer.valueOf(total.intValue() + (VSP.intValue() + ProcessFee.intValue() + miscReceipts.intValue() + NOC.intValue() + ChangeOfNamePublication.intValue() + endomentCertificate.intValue() + reimbursementOFSalaryDeduction.intValue() + enrollmentApplication.intValue()));
		                  

		                  System.out.println(total);
		                  if (EnrollmentFee.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("EnrollmentFee", EnrollmentFee);
		                  }
		                  if (ReimbursementOFSalaryDeduction.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("ReimbursementOFSalaryDeduction", ReimbursementOFSalaryDeduction);
		                  }
		                  if (ClosingFD.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("ClosingFD", ClosingFD);
		                  }
		                  
		                  if (KSBCCostReceipt.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("KSBC CostReceipt", KSBCCostReceipt);
		                  }
		                  if (ElectionRules.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Election Rules", ElectionRules);
		                  }
		                  if (NominationForm.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Nomination Form", NominationForm);
		                  }
		                  
		                  if (VoterCD.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Voter CD", VoterCD);
		                  }
		                  
		                  if (ElectionDeposit.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Election Deposit", VoterCD);
		                  }
		                  
		                  if (PDC.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("PDC", PDC);
		                  }
		                  
		                  if (DOBCertificate.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("DOB Certificate", DOBCertificate);
		                  }
		                  
		                  if (CertificateCopyCharges.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Certificate Copy Charges", CertificateCopyCharges);
		                  }
		                  if (PostageReceipts.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Postage Receipts", PostageReceipts);
		                  }
		                  if (DuplicateEnrollment.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Duplicate Enrollment", DuplicateEnrollment);
		                  }
		                  if (EndomentCertificate.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Endoment Certificate", EndomentCertificate);
		                  }
		                  






		                  if (KSBCInterestONFD.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("KSBC Interest ON FD", KSBCInterestONFD);
		                  }
		                  
		                  if (EnrollmentApplication.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Enrollment Application", EnrollmentApplication);
		                  }
		                  
		                  if (IdentityCard.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Identity Card", IdentityCard);
		                  }
		                  

		                  if (ComplaintFee.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Complaint Fee", ComplaintFee);
		                  }
		                  if (ChangeOfAddress.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Change Of Address", ChangeOfAddress);
		                  }
		                  if (ContinuityCertificate.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Continuity Certificate", ContinuityCertificate);
		                  }
		                  

		                  if (VSP.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("VSP", VSP);
		                  }
		                  
		                  if (ProcessFee.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Proces sFee", ProcessFee);
		                  }
		                  






		                  if (NOC.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("NOC", NOC);
		                  }
		                  




		                  if (ChangeOfNamePublication.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("Change Of Name Publication", ChangeOfNamePublication);
		                  }
		                  if (endomentCertificate.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("endoment Certificate", endomentCertificate);
		                  }
		                  if (reimbursementOFSalaryDeduction.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("reimbursement OF Salary Deduction", reimbursementOFSalaryDeduction);
		                  }
		                  

		                  if (enrollmentApplication.intValue() > 0)
		                  {
		                    mapChallanScannedCopy.put("enrollment Application", enrollmentApplication);
		                  }
		                  



		                  FeeStructureForKAR FeeStructureForKAR = new FeeStructureForKAR();
		                  
		                  FeeStructureForKAR.setCertificateCopyCharges(CertificateCopyCharges);
		                  FeeStructureForKAR.setChangeOfAddress(ChangeOfAddress);
		                  FeeStructureForKAR.setChangeOfNamePublication(ChangeOfNamePublication);
		                  FeeStructureForKAR.setClosingFD(ClosingFD);
		                  FeeStructureForKAR.setComplaintFee(ComplaintFee);
		                  FeeStructureForKAR.setContinuityCertificate(ContinuityCertificate);
		                  FeeStructureForKAR.setDOBCertificate(DOBCertificate);
		                  FeeStructureForKAR.setDuplicateEnrollemt(DuplicateEnrollment);
		                  FeeStructureForKAR.setElectionDeposit(ElectionDeposit);
		                  FeeStructureForKAR.setElectionRules(ElectionRules);
		                  
		                  FeeStructureForKAR.setEndomentCertificate(endomentCertificate);
		                  FeeStructureForKAR.setEnrollmentApplication(enrollmentApplication);
		                  
		                  FeeStructureForKAR.setIdentityCard(IdentityCard);
		                  FeeStructureForKAR.setKARNumber(KARNumber);
		                  FeeStructureForKAR.setKSBCCostReceipt(KSBCCostReceipt);
		                  FeeStructureForKAR.setKSBCInterestONFD(KSBCInterestONFD);
		                  FeeStructureForKAR.setMiscReceipts(miscReceipts);
		                  FeeStructureForKAR.setNameOftheClient(NameOftheClient);
		                  FeeStructureForKAR.setNOC(NOC);
		                  FeeStructureForKAR.setNominationForm(NominationForm);
		                  FeeStructureForKAR.setPDC(PDC);
		                  FeeStructureForKAR.setPlaceOftheClient(PlaceOftheClient);
		                  FeeStructureForKAR.setPostageReceipts(PostageReceipts);
		                  FeeStructureForKAR.setProcessFee(ProcessFee);
		                  FeeStructureForKAR.setReimbursementOFSalaryDeduction(reimbursementOFSalaryDeduction);
		                  













		                  
		                  String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		                  
		                  responseString = "";
		                  System.out.println(responseString);


		                }
		                 if (AjaxPage.equalsIgnoreCase("ViewKARStatus"))
		                {

		                  String KARNumber = request.getParameter("KARNumber");
		                  String WhichPhoto = request.getParameter("WhichPhoto");
		                  responseString = "<img alt=\"Image\" src=\"KARNumberImageServlet?KARNumber=" + KARNumber + "&WhichPhoto=" + WhichPhoto + "\">";

		                }
		                 if (AjaxPage.equalsIgnoreCase("GetKARBillingStatus"))
		                {

		                  String KARNumber = request.getParameter("KARNumber");
		                  AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                  responseString = AccountJSPRelatedFunctionsImp.GetBillingDetails(KARNumber);

		                }
		                 if (AjaxPage.equalsIgnoreCase("ViewAllBillingStatus"))
		                {

		                  String KARNumber = request.getParameter("KARNumber");
		                  AccountJSPRelatedFunctionsImp AccountJSPRelatedFunctionsImp = new AccountJSPRelatedFunctionsImp();
		                  responseString = AccountJSPRelatedFunctionsImp.GetAllBillingDetailsForWelfare(KARNumber);



		                }
		                 if (AjaxPage.equalsIgnoreCase("SeeAdvocateDetails"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  
		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  responseString = JSPRelatedFunctionsimp.GetWelfareFund(KARNumber);

		                }
		                 if (AjaxPage.equalsIgnoreCase("GetStatusFromKARNumber"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  
		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  responseString = JSPRelatedFunctionsimp.CheckForStatus(KARNumber);

		                }
		                 if (AjaxPage.equalsIgnoreCase("DailyReportForInidividualAssociation"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                  String StartDate = request.getParameter("StartDate");
		                  
		                  System.out.println(StartDate + "   Start date");
		                  java.util.Date parsedStartDate = null;
		                  java.sql.Date StartDateSQLdate = null;
		                  try
		                  {
		                    parsedStartDate = format.parse(StartDate);
		                    
		                    System.out.println(parsedStartDate + "  parsedStartDate");
		                    StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                    
		                    System.out.println(StartDateSQLdate + " Sql Date");
		                  }
		                  catch (ParseException e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GenerateStampSectionIndividualDailyReport(StartDateSQLdate);
		                  System.out.println(responseString);



		                }
		                 if (AjaxPage.equalsIgnoreCase("DailyReportForStampAssociation"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                  String StartDate = request.getParameter("StartDate");
		                  
		                  System.out.println(StartDate + "   Start date");
		                  java.util.Date parsedStartDate = null;
		                  java.sql.Date StartDateSQLdate = null;
		                  try
		                  {
		                    parsedStartDate = format.parse(StartDate);
		                    
		                    System.out.println(parsedStartDate + "  parsedStartDate");
		                    StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                    
		                    System.out.println(StartDateSQLdate + " Sql Date");
		                  }
		                  catch (ParseException e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GenerateStampSectionAssosiationDailyReport(StartDateSQLdate);
		                  System.out.println(responseString);



		                }
		                 if (AjaxPage.equalsIgnoreCase("DailyReportForCashSection"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                  String StartDate = request.getParameter("StartDate");
		                  
		                  System.out.println(StartDate + "   Start date");
		                  java.util.Date parsedStartDate = null;
		                  java.sql.Date StartDateSQLdate = null;
		                  try
		                  {
		                    parsedStartDate = format.parse(StartDate);
		                    
		                    System.out.println(parsedStartDate + "  parsedStartDate");
		                    StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                    
		                    System.out.println(StartDateSQLdate + " Sql Date");
		                  }
		                  catch (ParseException e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GenerateDailyReport(StartDateSQLdate);
		                  System.out.println(responseString);

		                }
		                 if (AjaxPage.equalsIgnoreCase("DailyReportForCashSectionWithOperator"))
		                {

		                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                  String StartDate = request.getParameter("StartDate");
		                  String Operator = request.getParameter("Operator");
		                  
		                  System.out.println(StartDate + "   Start date");
		                  java.util.Date parsedStartDate = null;
		                  java.sql.Date StartDateSQLdate = null;
		                  try
		                  {
		                    parsedStartDate = format.parse(StartDate);
		                    
		                    System.out.println(parsedStartDate + "  parsedStartDate");
		                    StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                    
		                    System.out.println(StartDateSQLdate + " Sql Date");
		                  }
		                  catch (ParseException e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GenerateDailyReportForUser(StartDateSQLdate, Operator);
		                  System.out.println(responseString);

		                }
		                 if (AjaxPage.equalsIgnoreCase("DailyReportForCOPCashSectionWithOperator"))
		                {

		                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                  String StartDate = request.getParameter("StartDate");
		                  String Operator = request.getParameter("Operator");
		                  
		                  System.out.println(StartDate + "   Start date");
		                  java.util.Date parsedStartDate = null;
		                  java.sql.Date StartDateSQLdate = null;
		                  try
		                  {
		                    parsedStartDate = format.parse(StartDate);
		                    
		                    System.out.println(parsedStartDate + "  parsedStartDate");
		                    StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                    
		                    System.out.println(StartDateSQLdate + " Sql Date");
		                  }
		                  catch (ParseException e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GenerateCOPDailyReportForUser(StartDateSQLdate, Operator);
		                  System.out.println(responseString);



		                }
		                 if (AjaxPage.equalsIgnoreCase("DailyReportForCashSectionCOP"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                  String StartDate = request.getParameter("StartDate");
		                  
		                  System.out.println(StartDate + "   Start date");
		                  java.util.Date parsedStartDate = null;
		                  java.sql.Date StartDateSQLdate = null;
		                  try
		                  {
		                    parsedStartDate = format.parse(StartDate);
		                    
		                    System.out.println(parsedStartDate + "  parsedStartDate");
		                    StartDateSQLdate = new java.sql.Date(parsedStartDate.getTime());
		                    
		                    System.out.println(StartDateSQLdate + " Sql Date");
		                  }
		                  catch (ParseException e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  
		                  responseString = JSPRelatedFunctionsimp.GenerateCOPDailyReport(StartDateSQLdate);
		                  System.out.println(responseString);




		                }
		                 if (AjaxPage.equalsIgnoreCase("DownloadthePDFFile"))
		                {

		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  responseString = "<form id='FormForScheduleInterview'><input type='hidden' value=''  name='FileName' id='FileName'><input type='button' class='btn btn-info' name='ScheduleInterview' value='Schedule Interview'  id='ScheduleInterview'  >\t</form> <script>     $('#ScheduleInterview').click(function(event) { alert('********** ScheduleInterview ***********'); var FileName=$('#FileName').val();          $.get('AjaxServlet',{FileName:FileName},function(responseText) {   $('#Main_Content1').html(responseText);  });   });     </script> ";



























		                }
		                 if (AjaxPage.equalsIgnoreCase("SeeAdvocateLastPay"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  
		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  responseString = JSPRelatedFunctionsimp.GetWelfareFundLastPay(KARNumber);



		                }
		                 if (AjaxPage.equalsIgnoreCase("KARLoginCheck"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  
		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  EnrollmentDetails EnrollmentDetails = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		                  
		                  responseString = EnrollmentDetails.getName();


		                }
		                 if (AjaxPage.equalsIgnoreCase("GetEnrollmentDetailsForCashSection"))
		                {

		                  System.out.println("!!!!!!!!!#$$$$$$$$$$$$$$$$$%%%%%%%%%%%%%%%%%%%%%%%%%%%%$$$$$$$$$$");
		                  
		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  EnrollmentDetails EnrollmentDetails = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		                  
		                  responseString = EnrollmentDetails.getName() + "," + EnrollmentDetails.getPermanent_City();
		                  
		                  System.out.println(responseString + " YYYYYYYYYYYYYYYYYYYYYY");

		                }
		                 if (AjaxPage.equalsIgnoreCase("GetEnrollmentDetailsForCashSection1"))
		                {

		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  EnrollmentDetails EnrollmentDetails = JSPRelatedFunctionsimp.GetEnrollmentDetails(KARNumber);
		                  String ResultString1 = JSPRelatedFunctionsimp.GetPayBalenceForKARNumberForDisplay(KARNumber);
		                  


		                  System.out.println(ResultString1 + "  ResultString");
		                  responseString = EnrollmentDetails.getName() + "divForKSBC" + EnrollmentDetails.getPermanent_City() + "divForKSBC" + ResultString1;
		                  
		                  System.out.println(responseString + " YYYYYYYYYYYYYYYYYYYYYY");



		                }
		                 if (AjaxPage.equalsIgnoreCase("GetFeeForWelfareToDisplay"))
		                {


		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  String EnrollmentDetails = JSPRelatedFunctionsimp.GetPayBalenceForKARNumberForDisplay(KARNumber);
		                  
		                  responseString = EnrollmentDetails;
		                  
		                  System.out.println(responseString + " YYYYYYYYYYYYYYYYYYYYYY");




		                }
		                 if (AjaxPage.equalsIgnoreCase("GetTotalForNewEnrollment"))
		                {

		                  int EnrollmentFee = 0;
		                  
		                  System.out.println(EnrollmentFee + "  EnrollmentFee");
		                  

		                  int CertificateVerificationFee = 0;
		                  try
		                  {
		                    CertificateVerificationFee = Integer.parseInt(request.getParameter("CertificateVerificationFee"));

		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    CertificateVerificationFee = 0;
		                  }
		                  

		                  int category = 0;
		                  System.out.println(request.getParameter("category") + " arun");
		                  try
		                  {
		                    category = Integer.parseInt(request.getParameter("category"));

		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                    category = 0;
		                  }
		                  

		                  System.out.println(category + "category");
		                  


		                  int IdentityCar = Integer.parseInt(request.getParameter("identityCard"));
		                  System.out.println(IdentityCar);
		                  int miscRts = Integer.parseInt(request.getParameter("miscRts"));
		                  System.out.println(miscRts);
		                  int KsbcTrust = Integer.parseInt(request.getParameter("KsbcTrust"));
		                  System.out.println(KsbcTrust);
		                  
		                  int KawfMembershipFee = 0;
		                  try
		                  {
		                    KawfMembershipFee = Integer.parseInt(request.getParameter("KawfMembershipFee"));
		                    
		                    System.out.println(KawfMembershipFee);
		                  }
		                  catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  int BciSubscriptio = Integer.parseInt(request.getParameter("BciSubscription"));
		                  System.out.println(BciSubscriptio);
		                  int fds = 0;
		                  try {
		                    fds = Integer.parseInt(request.getParameter("fds"));
		                    System.out.println(fds);
		                  }
		                  catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  System.out.println(fds);
		                  

		                  long total = category + CertificateVerificationFee + IdentityCar + BciSubscriptio + fds + KawfMembershipFee + KsbcTrust + miscRts;
		                  
		                  responseString = total + "";
		                  
		                  System.out.println(responseString);



		                }
		                 if (AjaxPage.equalsIgnoreCase("GetTotalKSBCfeetotal"))
		                {
		                  Integer ReimbursementOFSalaryDeduction = Integer.valueOf(Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction")));
		                  

		                  Integer ClosingFD = Integer.valueOf(Integer.parseInt(request.getParameter("ClosingFD")));
		                  

		                  Integer KSBCCostReceipt = Integer.valueOf(Integer.parseInt(request.getParameter("KSBCCostReceipt")));
		                  

		                  Integer GOvtGrant = Integer.valueOf(Integer.parseInt(request.getParameter("GOvtGrant")));
		                  Integer ElectionRules = Integer.valueOf(Integer.parseInt(request.getParameter("ElectionRules")));
		                  
		                  Integer NominationForm = Integer.valueOf(Integer.parseInt(request.getParameter("NominationForm")));
		                  
		                  Integer VoterCD = Integer.valueOf(Integer.parseInt(request.getParameter("VoterCD")));
		                  
		                  String DDDate = request.getParameter("DDDate");
		                  System.out.println(DDDate);
		                  
		                  Integer ElectionDeposit = Integer.valueOf(Integer.parseInt(request.getParameter("ElectionDeposit")));
		                  HttpSession Servletsession = request.getSession(false);
		                  if (Servletsession == null)
		                  {
		                    Servletsession = request.getSession(true);
		                  }
		                  
		                  String Operator = (String)Servletsession.getAttribute("UserName");
		                  
		                  System.out.println(Operator + " Operator");
		                  
		                  Integer PDC = Integer.valueOf(Integer.parseInt(request.getParameter("PDC")));
		                  
		                  Integer DOBCertificate = Integer.valueOf(Integer.parseInt(request.getParameter("DOBCertificate")));
		                  
		                  Integer CertificateCopyCharges = Integer.valueOf(Integer.parseInt(request.getParameter("CertificateCopyCharges")));
		                  
		                  Integer PostageReceipts = Integer.valueOf(Integer.parseInt(request.getParameter("PostageReceipts")));
		                  


		                  Integer DuplicateEnrollment = Integer.valueOf(Integer.parseInt(request.getParameter("DuplicateEnrollemt")));
		                  

		                  Integer EndomentCertificate = Integer.valueOf(Integer.parseInt(request.getParameter("EndomentCertificate")));
		                  Integer KSBCInterestONFD = Integer.valueOf(Integer.parseInt(request.getParameter("KSBCInterestONFD")));
		                  String PlaceOftheClient = request.getParameter("Place");
		                  int EnrollmentApplication = 0;
		                  try {
		                    EnrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
		                  }
		                  catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  Integer IdentityCard = Integer.valueOf(Integer.parseInt(request.getParameter("IdentityCard")));
		                  String NameOftheClient = request.getParameter("Name");
		                  
		                  System.out.println(NameOftheClient + "  Name");
		                  int ComplaintFee = 0;
		                  try {
		                    ComplaintFee = Integer.parseInt(request.getParameter("ComplaintFee"));
		                  } catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  int ChangeOfAddress = 0;
		                  try {
		                    ChangeOfAddress = Integer.parseInt(request.getParameter("ChangeOfAddress"));
		                  } catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  int ContinuityCertificate = 0;
		                  try {
		                    ContinuityCertificate = Integer.parseInt(request.getParameter("ContinuityCertificate"));
		                  } catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  int VSP = 0;
		                  try {
		                    VSP = Integer.parseInt(request.getParameter("vsp"));
		                  } catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  int ProcessFee = 0;
		                  try {
		                    ProcessFee = Integer.parseInt(request.getParameter("ProcessFee"));
		                  } catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  Integer miscReceipts = Integer.valueOf(Integer.parseInt(request.getParameter("MiscReceipts")));
		                  
		                  int NOC = 0;
		                  try {
		                    NOC = Integer.parseInt(request.getParameter("NOC"));
		                  } catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  int ChangeOfNamePublication = 0;
		                  try {
		                    ChangeOfNamePublication = Integer.parseInt(request.getParameter("ChangeofNamePublication"));
		                    System.out.println("Akshay");
		                  } catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  int Resumption = 0;
		                  try {
		                    Resumption = Integer.parseInt(request.getParameter("Resumption"));
		                  }
		                  catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  Integer endomentCertificate = Integer.valueOf(Integer.parseInt(request.getParameter("EndomentCertificate")));
		                  Integer reimbursementOFSalaryDeduction = Integer.valueOf(Integer.parseInt(request.getParameter("ReimbursementOFSalaryDeduction")));
		                  

		                  int enrollmentApplication = 0;
		                  try {
		                    enrollmentApplication = Integer.parseInt(request.getParameter("EnrollmentApplication"));
		                  }
		                  catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  long total = ReimbursementOFSalaryDeduction.intValue() + ClosingFD.intValue() + KSBCCostReceipt.intValue() + ElectionRules.intValue();
		                  total += NominationForm.intValue() + VoterCD.intValue() + ElectionDeposit.intValue() + PDC.intValue() + DOBCertificate.intValue() + PostageReceipts.intValue() + DuplicateEnrollment.intValue() + EndomentCertificate.intValue();
		                  total += KSBCInterestONFD.intValue() + EnrollmentApplication + IdentityCard.intValue() + ComplaintFee + ChangeOfAddress + ContinuityCertificate;
		                  total += CertificateCopyCharges.intValue() + VSP + ProcessFee + miscReceipts.intValue() + NOC + ChangeOfNamePublication + GOvtGrant.intValue() + Resumption;
		                  
		                  responseString = total + "";


		                }
		                 if (AjaxPage.equalsIgnoreCase("GetTotalKAWFfeetotal"))
		                {

		                  int seniorAdvocateLateFee = Integer.parseInt(request.getParameter("seniorAdvFee"));
		                  System.out.println(seniorAdvocateLateFee + "seniorAdvocateLateFee");
		                  

		                  int WFReimbursmentOfsalaryDeduction = Integer.parseInt(request.getParameter("WFsalDeduction"));
		                  int WelfareFundInterestOnFD = Integer.parseInt(request.getParameter("InterestFD"));
		                  int WelfareFundClosingFD = Integer.parseInt(request.getParameter("closingFD"));
		                  int SaleofStampAmount = Integer.parseInt(request.getParameter("stamp"));
		                  



		                  int ThisYear = 0;
		                  try
		                  {
		                    ThisYear = Integer.parseInt(request.getParameter("ThisYear"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  int PriviousYear = 0;
		                  try
		                  {
		                    PriviousYear = Integer.parseInt(request.getParameter("PriviousYear"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  int KawfSubscriptionForPlender = 0;
		                  try
		                  {
		                    KawfSubscriptionForPlender = Integer.parseInt(request.getParameter("KawfSubscriptionForPlender"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  

		                  int LifeMembershipFee = 0;
		                  try
		                  {
		                    LifeMembershipFee = Integer.parseInt(request.getParameter("LifeMembershipFee"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  int SeniorAdvocateContribution = 0;
		                  try {
		                    SeniorAdvocateContribution = Integer.parseInt(request.getParameter("SeniorAdvocateContribution"));
		                  }
		                  catch (Exception exception) {
		                    exception.printStackTrace();
		                  }
		                  int ChangeofNominee = 0;
		                  try
		                  {
		                    ChangeofNominee = Integer.parseInt(request.getParameter("ChangeofNominee"));
		                  }
		                  catch (Exception e) {
		                    e.printStackTrace();
		                  }
		                  
		                  int Govtgrant = Integer.parseInt(request.getParameter("grant"));
		                  int Miscellaneous = Integer.parseInt(request.getParameter("misc"));
		                  int DuplicateCertificate = 0;
		                  try {
		                    DuplicateCertificate = Integer.parseInt(request.getParameter("DuplicateCertificate"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  int WelfareFundCostReceipts = Integer.parseInt(request.getParameter("wfCost"));
		                  
		                  int donation = Integer.parseInt(request.getParameter("donation"));
		                  
		                  int subscriptionLateFee = Integer.parseInt(request.getParameter("subscriptionFee"));
		                  

		                  long total = PriviousYear + ThisYear + KawfSubscriptionForPlender + SeniorAdvocateContribution + ChangeofNominee + DuplicateCertificate + WelfareFundCostReceipts + donation + subscriptionLateFee + seniorAdvocateLateFee + WFReimbursmentOfsalaryDeduction + WelfareFundInterestOnFD + WelfareFundClosingFD + SaleofStampAmount + LifeMembershipFee + Govtgrant + Miscellaneous;
		                  

		                  responseString = total + "";
		                  
		                  System.out.println(responseString);


		                }
		                 if (AjaxPage.equalsIgnoreCase("GetTotalKAWFlatefeetotal"))
		                {


		                  int WFLateFee = Integer.parseInt(request.getParameter("WFLateFee"));
		                  System.out.println(WFLateFee);
		                  int KAWFMembershipFee = 0;
		                  System.out.println(request.getParameter("KAWFfee"));
		                  try
		                  {
		                    KAWFMembershipFee = Integer.parseInt(request.getParameter("KAWFfee"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  long total = KAWFMembershipFee + WFLateFee;
		                  responseString = total + "";

		                }
		                 if (AjaxPage.equalsIgnoreCase("GetTotalCOPfeetotal"))
		                {


		                  int InterestONFD = Integer.parseInt(request.getParameter("InterestONFD"));
		                  int ClosingFD = Integer.parseInt(request.getParameter("ClosingFD"));
		                  int COPApplicationLateFee = Integer.parseInt(request.getParameter("COPApplicationLateFee"));
		                  int KSBCCOPFEE = Integer.parseInt(request.getParameter("KSBCCOPFEE"));
		                  int RESCFee = Integer.parseInt(request.getParameter("RESCFee"));
		                  int MiscFee = Integer.parseInt(request.getParameter("MiscFee"));
		                  int COPSenioradvc = Integer.parseInt(request.getParameter("COPSenioradvc"));
		                  

		                  System.out.println(InterestONFD);
		                  int COPApplicationFee = 0;
		                  System.out.println(request.getParameter("COPApplicationFee"));
		                  try
		                  {
		                    COPApplicationFee = Integer.parseInt(request.getParameter("COPApplicationFee"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  long total = KSBCCOPFEE + RESCFee + MiscFee + COPApplicationFee + InterestONFD + ClosingFD + COPApplicationLateFee + COPSenioradvc;
		                  responseString = total + "";


		                }
		                 if (AjaxPage.equalsIgnoreCase("GetTotalForAssociate"))
		                {


		                  int AssociationStampFee = 0;
		                  System.out.println(request.getParameter("Stampfee") + "stamp");
		                  try
		                  {
		                    AssociationStampFee = Integer.parseInt(request.getParameter("Stampfee"));

		                  }
		                  catch (Exception e)
		                  {

		                    e.printStackTrace();
		                  }
		                  

		                  int PostalCharges = 0;
		                  System.out.println(request.getParameter("PostalCharges"));
		                  try
		                  {
		                    PostalCharges = Integer.parseInt(request.getParameter("PostalCharges"));
		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  
		                  long total = AssociationStampFee + PostalCharges;
		                  
		                  responseString = total + "";
		                }
		                 if (AjaxPage.equalsIgnoreCase("GetTotalForBci"))
		                {


		                  int BCISubscriptionLateFee = Integer.parseInt(request.getParameter("BCISubscriptionLateFee"));
		                  


		                  int FDSDiffAmt = Integer.parseInt(request.getParameter("FDSDiffAmt"));
		                  


		                  int BCISubscription = Integer.parseInt(request.getParameter("BCISubscription"));
		                  

		                  int FDS = 0;
		                  try
		                  {
		                    FDS = Integer.parseInt(request.getParameter("FDS"));

		                  }
		                  catch (Exception e)
		                  {
		                    e.printStackTrace();
		                  }
		                  



		                  int CostReceipt = Integer.parseInt(request.getParameter("CostReceipt"));
		                  
		                  int BCIReimbursmentOfSalaryDeduction = Integer.parseInt(request.getParameter("BCIReimbursment"));
		                  
		                  int BCIInterestonFD = Integer.parseInt(request.getParameter("BCIInterestonFD"));
		                  

		                  int BCIClosingFD = Integer.parseInt(request.getParameter("BCIClosingFD"));
		                  int FDSInterestonFD = Integer.parseInt(request.getParameter("FDSInterestonFD"));
		                  int FDSClosingFD = Integer.parseInt(request.getParameter("FDSClosingFD"));
		                  
		                  HttpSession Servletsession = request.getSession(false);
		                  if (Servletsession == null)
		                  {
		                    Servletsession = request.getSession(true);
		                  }
		                  
		                  String Operator = (String)Servletsession.getAttribute("UserName");
		                  
		                  System.out.println(Operator + " Operator");
		                  

		                  long total = BCIClosingFD + BCIInterestonFD + BCIReimbursmentOfSalaryDeduction + BCISubscription + BCISubscriptionLateFee + CostReceipt + FDSClosingFD + FDS + FDSDiffAmt + FDSInterestonFD;
		                  
		                  System.out.println("TOTAL AMOUNT::" + total);
		                  responseString = total + "";
		                  
		                  System.out.println(responseString + " YYYYYYYYYYYYYYYYYYYYYY");

		                }
		                 if (AjaxPage.equalsIgnoreCase("GetFeeForWelfareToDisplayForTotal"))
		                {


		                  String KARNumber = request.getParameter("KARNumber");
		                  
		                  int ThisYear = 0;
		                  try
		                  {
		                    ThisYear = Integer.parseInt(request.getParameter("ThisYear"));
		                  }
		                  catch (Exception exception) {
		                    exception.printStackTrace();
		                  }
		                  System.out.println(ThisYear + "   ThisYear");
		                  int PriviousYear = 0;
		                  try {
		                    PriviousYear = Integer.parseInt(request.getParameter("PriviousYear"));
		                  }
		                  catch (Exception exception) {
		                    exception.printStackTrace();
		                  }
		                  System.out.println(PriviousYear + "   PriviousYear");
		                  
		                  long total = ThisYear + PriviousYear;
		                  
		                  String ResultString = "<table><tbody> <tr>  <td><b>KAWF Subscription</b></td>  <td><b> " + total + "  </b></td>  </tr>";
		                  







		                  ResultString = ResultString + " </tbody> </table>";
		                  responseString = ResultString;
		                  
		                  System.out.println(responseString + " YYYYYYYYYYYYYYYYYYYYYY");
		                } 
		    response.setContentType("text/plain;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println(responseString );
		              }
		        
	 
	
	
	 
	

	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
