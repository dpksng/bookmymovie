function nowShowing(){
	document.getElementById("upcoming").style.display="none";
	document.getElementById("nowshowing").style.display="block";
	document.getElementById("btn-l").className="btn-b";
	document.getElementById("btn-r").className="btn-e";
}
		
function upComing(){
	document.getElementById("nowshowing").style.display="none";
	document.getElementById("upcoming").style.display="block";
	document.getElementById("btn-r").className="btn-b";
	document.getElementById("btn-l").className="btn-e";
}
