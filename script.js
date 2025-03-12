document.addEventListener('DOMContentLoaded', () => {
    const elements = document.querySelectorAll('.fade-in, .slide-in-left, .slide-in-right, .grow-in, .fade-in-up, .spin-in, .rotate-in, .fade-up, .wave-in, .wave-text, .slide-up, .glow-in, .shine-in, .zoom-in');
    
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');
            }
        });
    }, { threshold: 0.5 });

    elements.forEach(el => observer.observe(el));
});

const style = document.createElement('style');
style.innerHTML = `
    .fade-in.visible { animation: fadeIn 1s ease-in; }
    .slide-in-left.visible { animation: slideInLeft 1s ease-out; }
    .slide-in-right.visible { animation: slideInRight 1s ease-out; }
    .grow-in.visible { animation: growIn 0.8s ease-out; }
    .fade-in-up.visible { animation: fadeInUp 1s ease-out; }
    .spin-in.visible { animation: spinIn 1.5s ease-out; }
    .rotate-in.visible { animation: rotateIn 1s ease-out; }
    .fade-up.visible { animation: fadeUp 1s ease-out; }
    .wave-in.visible { animation: waveIn 1.2s ease-out; }
    .wave-text.visible { animation: waveText 1s ease-out; }
    .slide-up.visible { animation: slideUp 1s ease-out; }
    .glow-in.visible { animation: glowIn 1.5s ease-out; }
    .shine-in.visible { animation: shineIn 1s ease-out; }
    .zoom-in.visible { animation: zoomIn 1s ease-out; }
`;
document.head.appendChild(style);