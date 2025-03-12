// Hiệu ứng slideshow
let slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("slide");
    let dots = document.getElementsByClassName("dot");
    
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
}

// Tự động chuyển slide mỗi 3 giây
setInterval(() => {
    plusSlides(1);
}, 3000);

// Hiệu ứng thanh kỹ năng
const skillBars = document.querySelectorAll('.skill-bar');
skillBars.forEach(bar => {
    bar.addEventListener('mouseover', () => {
        bar.style.setProperty('--width', '100%');
    });
    bar.addEventListener('mouseout', () => {
        bar.style.setProperty('--width', bar.getAttribute('data-percent') + '%');
    });
});

// Hiệu ứng khi cuộn trang
window.addEventListener('scroll', () => {
    const sections = document.querySelectorAll('section');
    sections.forEach(section => {
        const sectionTop = section.getBoundingClientRect().top;
        const windowHeight = window.innerHeight;
        if (sectionTop < windowHeight * 0.8) {
            section.style.opacity = '1';
            section.style.transform = 'translateY(0)';
        }
    });
});

// Hiệu ứng khi trang được tải
document.addEventListener('DOMContentLoaded', () => {
    const sections = document.querySelectorAll('section');
    sections.forEach(section => {
        section.style.opacity = '0';
        section.style.transform = 'translateY(20px)';
        section.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
    });

    // Tự động chạy thanh kỹ năng khi load trang
    skillBars.forEach(bar => {
        const percent = bar.getAttribute('data-percent') + '%';
        bar.classList.add('loaded');
        bar.style.setProperty('--width', percent);
    });
});