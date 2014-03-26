function check() {
	var interval = setInterval("Push()", 5000);
}

function Push() {
	$.ajax({
				type : "POST",
				url : encodeURI("test_File_doLog"),
				success : function(data) {
					$('#context').text(data);
					if (data.search("FINISHED") != -1) {
						clearInterval(interval);
						document.getElementById("pic").style.display = "none";
						if (data.search("JMETER") != -1) {

							var sessionid = data.substring(data
									.indexOf("SOHUTESTID") + 10);
							var date = data.substring(data.indexOf

							("SOHUTESTDATE") + 12,
									data.indexOf("SOHUTESTDATE") + 20);
							// alert(date);
							document.getElementById("RT").innerHTML = "<img src='log/"
									+ date

									+ "/JMRT" + sessionid + ".png'>";
							document.getElementById("TPS").innerHTML = "<img src='log/"
									+ date

									+ "/JMTPS" + sessionid + ".png'>";
							document.getElementById("BT").innerHTML = "<img src='log/"
									+ date

									+ "/JMBT" + sessionid + ".png'>";

							document.getElementsByClassName("graph")[0].style.display = "";
						}
					}
				}

}
