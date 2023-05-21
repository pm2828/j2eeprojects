<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/particlesjs/2.2.3/particles.js" integrity="sha512-BgV3bZfMmUklIZI+dP0SILdmQ0RBY2gxegFFyfgo4Ui56WhKF4Pny9LsV/l96jxDDA+2w47zAXA4IyHo2UT/Qg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
document.getElementById('searchBtn').addEventListener('click', function() {
	  var searchInput = document.getElementById('searchInput').value.toLowerCase();
	  var cards = document.getElementsByClassName('card');
	  
	  for (var i = 0; i < cards.length; i++) {
	    var cardTitle = cards[i].querySelector('.card-title').textContent.toLowerCase();
	    if (cardTitle.includes(searchInput)) {
	      cards[i].style.display = 'block';
	    } else {
	      cards[i].style.display = 'none';
	    }
	  }
	});

</script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
var status=document.getElementById("status").value;
if(status=="failed"){
	swal("Sorry","wrong  UserName or  Password","error");
}

</script>

