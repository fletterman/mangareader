const track = document.querySelector('.track');
const slides = Array.from(track.children);
const nextButton = document.querySelector('.button--right');
const prevButton = document.querySelector('.button--left');
const indicators = document.querySelector('.carouselNav');
const dots = Array.from(indicators.children);

const slideWidth = slides[0].getBoundingClientRect().width;

const setSlidePosition = (slide, index) => {
    slide.style.left = slideWidth * index + 'px';
};
slides.forEach(setSlidePosition);

const moveSlide = (track, currentSlide, targetSlide) => {
    track.style.transform = 'translateX(-' + targetSlide.style.left + ')';
    currentSlide.classList.remove('currentSlide');
    targetSlide.classList.add('currentSlide');
}

const updateDots = (currentDot, targetDot) => {
    currentDot.classList.remove('currentSlide');
    targetDot.classList.add('currentSlide');
}

nextButton.addEventListener('click', e => {
    const currentSlide = track.querySelector('.currentSlide');
    let nextSlide;
    let nextDot;
    const currentDot = indicators.querySelector('.currentSlide');
    if (currentSlide === slides[slides.length - 1]) {
        nextSlide = slides[0];
        nextDot = dots[0];
    } else {
        nextSlide = currentSlide.nextElementSibling;
        nextDot = currentDot.nextElementSibling
    }
    moveSlide(track, currentSlide, nextSlide);
    updateDots(currentDot, nextDot);
});

prevButton.addEventListener('click', e => {
    const currentSlide = track.querySelector('.currentSlide');
    let prevSlide;
    const currentDot = indicators.querySelector('.currentSlide');
    let prevDot;
    if (currentSlide === slides[0]) {
        prevSlide = slides[slides.length - 1];
        prevDot = dots[dots.length - 1];
    } else {
        prevSlide = currentSlide.previousElementSibling;
        prevDot = currentDot.previousElementSibling
    }
    moveSlide(track, currentSlide, prevSlide);
    updateDots(currentDot, prevDot);
});

indicators.addEventListener('click', e => {
    const targetDot = e.target.closest('button');
    if (!targetDot) return;
    const currentSlide = track.querySelector('.currentSlide');
    const currentDot = indicators.querySelector('.currentSlide');
    const targetIndex = dots.findIndex(dot => dot === targetDot);
    const targetSlide = slides[targetIndex];
    moveSlide(track, currentSlide, targetSlide);
    updateDots(currentDot, targetDot);
});

const dropdownClick = () => {
    document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
    if (!event.target.matches('.dropButton')) {
        const dropdowns = document.getElementsByClassName("dropdownContent");
        for (let i = 0; i < dropdowns.length; i++) {
            const openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}