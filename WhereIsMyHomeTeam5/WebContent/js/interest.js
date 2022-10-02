


function rm_tr_map_btn(idx){
	let root = window.location.pathname;
	  fetch(root+"?action=rminst&idx="+idx) 
	  .then((response) => response.json())
	  .then((data) => { 
	   if(data >0) {
		   document.getElementById("tr_"+idx).replaceChildren();
		   alert("삭제 되었습니다.");
	   }
	 }) 
}; 




function search_tr_map_btn(idx) {
	  
  	let root = window.location.pathname;   
  	
}
	  
