import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// Proxies /api/** to the quantityservice microservice during dev so there
// are ZERO CORS issues without touching backend SecurityConfig.
// Auth (Google OAuth2 login + JWT issuance) lives on authservice (port 8080)
// and is hit directly via config.backendOrigin, not through this proxy.
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
    proxy: {
      "/api": {
        target: "http://localhost:8081",
        changeOrigin: true,
      },
    },
  },
});