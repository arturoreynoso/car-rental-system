function parserDate(date) {
	let day = date.getDate();
  let month = date.getMonth() + 1;
  let year = date.getFullYear();
  if (day < 10) {
  	day = '0' + day;
  }
  if (month < 10) {
  	month = '0'+month;
  }
  date = year + '-' + month + '-' + day;
  return date;
}

todayString = parserDate(new Date());
document.getElementById("from").setAttribute("min", todayString);
futureDate = new Date();
futureDate.setMonth(futureDate.getMonth() + 6);
document.getElementById('from').setAttribute('value', todayString);
document.getElementById('from').setAttribute('max', parserDate(futureDate));

fromElement = document.getElementById('from');
from.addEventListener('input', function() {
let date = new Date(fromElement.value);
date.setDate(date.getDate()+2);
let dateString = parserDate(date);
const dateTo = document.getElementById('to');
dateTo.setAttribute('min', dateString);
date.setMonth(date.getMonth() + 1);
let dateStringTo = parserDate(date);
dateTo.setAttribute('max', dateStringTo);
})