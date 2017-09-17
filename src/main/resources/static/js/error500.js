var Gear = document.getElementById('Gear');

var MainBody = document.getElementById('MainBody');
                                     
var GearSpeed = 1;

Gear.addEventListener('click', function(ev){
    console.log(GearSpeed);
    Gear.style.cssText = 
 'animation-duration:' + GearSpeed +'s';
  GearSpeed = GearSpeed/1.2;
  if(GearSpeed <= 0.1) {
    MainBody.style.cssText = 'animation: ColorFiesta 3s infinite';
  }
});
