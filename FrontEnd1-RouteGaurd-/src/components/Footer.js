import React from 'react';
import {Link} from 'react-router-dom';
import { HashLink } from 'react-router-hash-link';
import './Footer.css';

const Footer = () => {
    return (
        <>
        {/* <footer className="bg-gray-800 border-t border-gray-700 py-8"></footer> */}
        <footer className="bg-gray-900 border-t border-gray-800 py-8 text-white">
    <div className="max-w-7xl mx-auto px-4 sm:px-6">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            {/* 1st block */}
            <div className="text-center">
                <p className="font-bold text-3xl mb-3">
                    RouteGuard<br />
                </p>
                <p>
                Kharghar,<br />
                    Mumbai,<br />
                    Maharashtra State.
                </p>
            </div>

            {/* 2nd block */}
            <div className="text-center">
                <h6 className="text-blue-400 text-xl font-bold mb-4">LINKS</h6>
                <ul className="text-md">
                    <li className="mb-2">
                        <HashLink to="#" className="text-white hover:text-gray-300">About</HashLink>
                    </li>
                    <li className="mb-2">
                        <HashLink to="#" className="text-white hover:text-gray-300">Services</HashLink>
                    </li>
                    <li className="mb-2">
                        <HashLink to="#" className="text-white hover:text-gray-300">Contact</HashLink>
                    </li>
                </ul>
            </div>

            {/* 3rd block */}
            <div className="text-center">
                <h6 className="text-blue-400 text-xl font-bold mb-4">OUR SERVICES</h6>
                <ul className="text-md">
                    <li className="mb-2">
                        <Link to="#" className="text-white hover:text-gray-300">Web Development</Link>
                    </li>
                    <li className="mb-2">
                        <Link to="#" className="text-white hover:text-gray-300">Mobile App Development</Link>
                    </li>
                    <li className="mb-2">
                        <Link to="#" className="text-white hover:text-gray-300">Domain and Hosting</Link>
                    </li>
                    <li className="mb-2">
                        <Link to="#" className="text-white hover:text-gray-300">General IT Consultations</Link>
                    </li>
                </ul>
            </div>
        </div>

        <div className="text-center mt-8">
            <h6 className="text-blue-400 text-xl font-bold mb-4">Follow Us</h6>
            <div className="flex justify-center space-x-4">
                <Link to="#" className="text-white hover:text-gray-500" aria-label="Twitter">
                    <svg className="w-8 h-8 fill-current" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg">
                        <path d="M24 11.5c-.6.3-1.2.4-1.9.5.7-.4 1.2-1 1.4-1.8-.6.4-1.3.6-2.1.8-.6-.6-1.5-1-2.4-1-1.7 0-3.2 1.5-3.2 3.3 0 .3 0 .5.1.7-2.7-.1-5.2-1.4-6.8-3.4-.3.5-.4 1-.4 1.7 0 1.1.6 2.1 1.5 2.7-.5 0-1-.2-1.5-.4 0 1.6 1.1 2.9 2.6 3.2-.3.1-.6.1-.9.1-.2 0-.4 0-.6-.1.4 1.3 1.6 2.3 3.1 2.3-1.1.9-2.5 1.4-4.1 1.4H8c1.5.9 3.2 1.5 5 1.5 6 0 9.3-5 9.3-9.3v-.4c.7-.5 1.3-1.1 1.7-1.8z" />
                    </svg>
                </Link>
                <Link to="#" className="text-white hover:text-gray-500" aria-label="Facebook">
                    <svg className="w-8 h-8 fill-current" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg">
                        <path d="M14.023 24L14 17h-3v-3h3v-2c0-2.7 1.672-4 4.08-4 1.153 0 2.144.086 2.433.124v2.821h-1.67c-1.31 0-1.563.623-1.563 1.536V14H21l-1 3h-2.72v7h-3.257z" />
                    </svg>
                </Link>
            </div>
        </div>

        <div className="text-center mt-8 text-gray-400 text-sm">
            <p>&copy; {new Date().getFullYear()} <HashLink to="#" className="text-white hover:text-gray-300">Molad e Konsult</HashLink>. All rights reserved.</p>
        </div>
    </div>
</footer>

        </>
    )
}
export default Footer;


{/* <footer className="bg-gray-900 border-t border-gray-800 py-8 text-white">
    <div className="max-w-7xl mx-auto px-4 sm:px-6">

        <div className="grid grid-cols-1 md:grid-cols-3 gap-8"> */}

            {/* 1st block */}
            {/* <div className="text-center text-white">
                <h3 className="font-bold text-3xl mb-4">MLD</h3>
                <p className="text-md font-medium">
                    RouteGuard<br />
                    Ilo Awela,<br />
                    Ota,<br />
                    Maharashtra State.
                </p>
            </div> */}

            {/* 2nd block */}
            {/* <div className="text-center text-white">
                <h6 className="text-blue-400 text-xl font-bold mb-4">LINKS</h6>
                <ul className="text-md">
                    <li className="mb-2">
                        <HashLink to="#" className="text-blue-400 hover:text-gray-300">About</HashLink>
                    </li>
                    <li className="mb-2">
                        <HashLink to="#" className="text-blue-400 hover:text-gray-300">Services</HashLink>
                    </li>
                    <li className="mb-2">
                        <HashLink to="#" className="text-blue-400 hover:text-gray-300">Contact</HashLink>
                    </li>
                </ul>
            </div> */}

            {/* 3rd block */}
            {/* <div className="text-center text-white">
                <h6 className="text-blue-400 text-xl font-bold mb-4">OUR SERVICES</h6>
                <ul className="text-md">
                    <li className="mb-2">
                        <Link to="#" className="text-blue-400 hover:text-gray-300">Web Development</Link>
                    </li>
                    <li className="mb-2">
                        <Link to="#" className="text-blue-400 hover:text-gray-300">Mobile App Development</Link>
                    </li>
                    <li className="mb-2">
                        <Link to="#" className="text-blue-400 hover:text-gray-300">Domain and Hosting</Link>
                    </li>
                    <li className="mb-2">
                        <Link to="#" className="text-blue-400 hover:text-gray-300">General IT Consultations</Link>
                    </li>
                </ul>
            </div>

        </div>

        <div className="text-center mt-8">
            <h6 className="text-blue-400 text-xl font-bold mb-4">Follow Us</h6>
            <div className="flex justify-center space-x-4">
                <Link to="#" className="text-blue-400 hover:text-gray-500" aria-label="Twitter">
                    <svg className="w-8 h-8 fill-current" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg">
                        <path d="M24 11.5c-.6.3-1.2.4-1.9.5.7-.4 1.2-1 1.4-1.8-.6.4-1.3.6-2.1.8-.6-.6-1.5-1-2.4-1-1.7 0-3.2 1.5-3.2 3.3 0 .3 0 .5.1.7-2.7-.1-5.2-1.4-6.8-3.4-.3.5-.4 1-.4 1.7 0 1.1.6 2.1 1.5 2.7-.5 0-1-.2-1.5-.4 0 1.6 1.1 2.9 2.6 3.2-.3.1-.6.1-.9.1-.2 0-.4 0-.6-.1.4 1.3 1.6 2.3 3.1 2.3-1.1.9-2.5 1.4-4.1 1.4H8c1.5.9 3.2 1.5 5 1.5 6 0 9.3-5 9.3-9.3v-.4c.7-.5 1.3-1.1 1.7-1.8z" />
                    </svg>
                </Link>
                <Link to="#" className="text-blue-400 hover:text-gray-500" aria-label="Facebook">
                    <svg className="w-8 h-8 fill-current" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg">
                        <path d="M14.023 24L14 17h-3v-3h3v-2c0-2.7 1.672-4 4.08-4 1.153 0 2.144.086 2.433.124v2.821h-1.67c-1.31 0-1.563.623-1.563 1.536V14H21l-1 3h-2.72v7h-3.257z" />
                    </svg>
                </Link>
            </div>
        </div>

        <div className="text-center mt-8 text-gray-400 text-sm">
            <p>&copy; {new Date().getFullYear()} <HashLink to="#" className="hover:text-gray-300">Molad e Konsult</HashLink>. All rights reserved.</p>
        </div>

    </div>
</footer> */}