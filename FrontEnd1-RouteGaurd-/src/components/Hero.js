
import React from 'react';
import { Carousel } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import NavBar from '../components/Navbar/NavBar';
//import heroImg from '../images/web-dev.svg';
import heroImg from 'C:/Users/arpit/FrontEnd1-RouteGaurd-/FrontEnd1-RouteGaurd-/src/images/Black and Orange Modern Logistics Corporate Presentation.jpg';
import heroImg2 from 'C:/Users/arpit/FrontEnd1-RouteGaurd-/FrontEnd1-RouteGaurd-/src/images/Black and Orange.jpg';

const Hero = () => {
    return (
        <>
            <div className="hero" id='hero'>
                <div>
                    <NavBar />
                </div>
                
            <Carousel className="corousel">
            <Carousel.Item className="item">
                <img
                    className="d-block w-100 corousel-img"
                    src={heroImg}
                    alt="Fourth slide"
                />
                <Carousel.Caption className="caption">
                <h1>
                </h1>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item className="item">
                <img
                    className="d-block w-100 corousel-img"
                    src={heroImg2}
                    alt="Fourth slide"
                />
                <Carousel.Caption className="caption">
                <h1>
                </h1>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>
            </div>
        </>
    );
}

export default Hero;
{/* <div className="m-auto overflow-hidden mx-4 mt-8 lg:mt-4 p-2 md:p-12 h-5/6" data-aos="zoom-in">
<div id='hero' className="flex flex-col lg:flex-row py-8 justify-between text-center lg:text-left">
    <div className="lg:w-1/2 flex flex-col justify-center" data-aos="zoom-in" data-aos-delay="200">
        <h1 className="mb-5 md:text-5xl text-3xl font-bold text-blue-900">
            Elevate Your Logistics with FleetLogix
        </h1>
        <p className="mb-5 md:text-3xl text-2xl font-semibold text-blue-700">
            Comprehensive Transportation Services for Every Need
           
        </p>
       
       
    </div>
    <div className="flex lg:justify-end w-full lg:w-1/2" data-aos="fade-up" data-aos-delay="700">
        <img alt="Transportation Services" className="rounded-t float-right duration-1000 w-full" src={heroImg} />
    </div>
</div>
</div> */}