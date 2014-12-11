package ie.gmit;

import java.rmi.*;

public interface RemoteFibonacci extends Remote {
	public String getFibonacciSequence(int max) throws RemoteException;
  // dont forget to delete those codes below,haha, don't wrry i'll do it))
	
	/*
	  <script type="text/javascript">
			function poll(){
				setTimeout(function() {
					$.ajax({type: 'POST', url: 'http://localhost:8080/Distributed_Project/Result_Page',
						success: function(data){
							alert(data);
						},
					complete: poll
					});
				}, 5000);
			}
		</script>onload = "poll()"
	  <script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" type = "text/javascript"></script>
	 */
	
	
	/*
	 * 
	 * <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
			<script type="text/javascript">
			function poll() {
			    setTimeout(function () {
			        $.ajax({
			            type: 'POST',
			            url: 'http://localhost:8080/Distributed_Project/Result_Page.jsp',
			            success: function (data) {
			             	
			             	
			             	
			  				 }
			            },
			            complete: poll
			        });
			    }, 5000);
			}
			</script>		
	 * 
	 * 
	 * 
	 * 
	 * 
		<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
		<script type="text/javascript" src="ajax.js"></script>
		
	 
		input <input id = "ip" type = "text" name = "" value = "/"><br></br>
		output <input id = "op" type = "text" name = "" value = "/"><br></br>
		<input type = "button" value = "Call servlet" name = "Call Servlet" id = "call"/>
		<div id = "output"></div>
		
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#call').click(function()
				{
					$.ajax({
						type: "POST",
						url: "TESTME",
						data: "input=" +$('#ip').val()+"&output="+$('#op').val(),
						success: function(msg){
							$('#output').append(msg);
						}
				});
				});
				});
			
		</script>
 
 
 
 
 <script type="text/javascript">
			function poll() {
			    setTimeout(function () {
			        $.ajax({
			            type: 'POST',
			            url: 'http://localhost:8080/Distributed_Project/Result_Page.jsp',
			            success: function (data) {
			               alert(data); //DatO ANY PROCESS HERE
			               document.getElementById("testid").value=data;
			               document.write(data)
			            },
			            complete: poll
			        });
			    }, 5000);
			}
			</script>
	</head>
<body onload="poll()">
	 
	 
	 */
}
