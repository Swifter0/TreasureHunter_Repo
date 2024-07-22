window.onload = function() {
	
	let allSquares = document.getElementsByClassName("square");
	
	randomizeTable(allSquares);
	
	for(let index = 0; index < allSquares.length; index++) {
		
		let currentSquare = allSquares[index];
		
		currentSquare.onclick = function() {
			
			clickHandler(currentSquare);
			
		}
		
		
	}
	
	
}

let win = 0; /** 0-Nothing, 1-Win, 2-Lose */
let steps = 0;

function clickHandler(clickedCell) {
	
	let stepsInnerHtml = document.getElementById("steps");
	
	if(win == 0) {
		
		steps++;
		stepsInnerHtml.innerHTML = "Steps :" + steps;
		
		
		if(clickedCell.classList.contains("firstChest")) {
			
			clickedCell.classList.add("chest");
			win = 1;
			setTimeout(endrequest, 2000);
			
		}
		else if(clickedCell.classList.contains("firstSkull")) {
			
			clickedCell.classList.add("skull");
			win = 2;
			setTimeout(endrequest, 2000);
						
		}
		else {
			
			clickedCell.classList.add("empty");
			
		}
			
	}
	
	
	
	
}

function endrequest() {
	
	let winFormElement = document.getElementById("winForm");
	let stepsFormElement = document.getElementById("stepsForm");
	let submitFormElement = document.getElementById("submitForm");
	
	winFormElement.value = win;
	stepsFormElement.value = steps;
	submitFormElement.click();
	
}

function randomizeTable(allSquares) {
	
	let randomNumberForChest = Math.round(Math.random() * 24);
	
	allSquares[randomNumberForChest].classList.add("firstChest");
	
	let placedRandomSkulls = 0;
	
	do {
		
		let randomNumberForSkull = Math.round(Math.random() * 24);

		if(allSquares[randomNumberForSkull].classList.contains("firstChest") == false &&
		allSquares[randomNumberForSkull].classList.contains("firstSkull") == false
		) {
			
			allSquares[randomNumberForSkull].classList.add("firstSkull");
			placedRandomSkulls++;
		}

	}while(placedRandomSkulls < 2);
	
	for(let index = 0; index < allSquares.length; index++) {
		
		if ((allSquares[index].classList.contains("firstChest") && allSquares[index].classList.contains("firstSkull")) == false) {
				
				allSquares[index].classList.add("firstEmpty");
				
			}
	}
}