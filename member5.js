// Hiệu ứng typing cho tagline
const tagline = document.getElementById('tagline');
const text = "[Một câu giới thiệu ngắn gọn về bạn]";
let index = 0;

function type() {
    if (index < text.length) {
        tagline.innerHTML += text.charAt(index);
        index++;
        setTimeout(type, 100);
    }
}

type();

// Hiệu ứng khi cuộn trang
window.addEventListener('scroll', () => {
    const sections = document.querySelectorAll('section');
    sections.forEach(section => {
        const sectionTop = section.getBoundingClientRect().top;
        const windowHeight = window.innerHeight;
        if (sectionTop < windowHeight * 0.8) {
            section.classList.add('visible');
        }
    });
});

// Hiệu ứng thanh kỹ năng
const skillBars = document.querySelectorAll('.skill-bar');
skillBars.forEach(bar => {
    const percent = bar.getAttribute('data-percent') + '%';
    bar.classList.add('loaded');
    bar.style.setProperty('--width', percent);
});