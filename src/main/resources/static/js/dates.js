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

function validateCheckboxes1()
{
    let checkboxes1=document.getElementsByName("brands");
    let okay1=false;
    for(let i=0,l1=checkboxes1.length;i<l1;i++)
    {
        if(checkboxes1[i].checked)
        {
            okay1=true;
            break;
        }
    }
    if(!okay1) {
        alert("You must select at least one brand.");
    }

    let checkboxes2=document.getElementsByName("carTypes");
    let okay2=false;
    for(let j=0,l2=checkboxes2.length;j<l2;j++)
    {
        if(checkboxes2[j].checked)
        {
            okay2=true;
            break;
        }
    }
    if(!okay2) {
        alert("You must select at least one car type.");
    }
}

todayString = parserDate(new Date());
document.getElementById("from").setAttribute("min", todayString);
futureDate = new Date();
futureDate.setMonth(futureDate.getMonth() + 6);
document.getElementById('from').setAttribute('value', todayString);
document.getElementById('from').setAttribute('max', parserDate(futureDate));

fromElement = document.getElementById('from');
toElement = document.getElementById('to');
to.addEventListener('input', function() {
let date = new Date(fromElement.value);
date.setDate(date.getDate()+2);
let dateString = parserDate(date);
const dateTo = document.getElementById('to');
dateTo.setAttribute('min', dateString);
date.setMonth(date.getMonth() + 1);
let dateStringTo = parserDate(date);
dateTo.setAttribute('max', dateStringTo);
})

const search = document.getElementById('search');
search.addEventListener('click', validateCheckboxes1);