# Learning Platform - Authentication System

This application implements JWT-based authentication with OAuth2 social login support. The system combines:
- Traditional username/password authentication
- Social login via OAuth2 providers
- Refresh token mechanism
- Role-based authorization

## Key Features

- **JWT Authentication**:
  - Access tokens (short-lived) + Refresh tokens (long-lived)
  - Stateless security architecture
  - Token validation and renewal

- **OAuth2 Integration**:
  - Google, Facebook, GitHub login support
  - Automatic user registration
  - JWT generation after social login

- **Security**:
  - Password encryption (BCrypt)
  - CSRF protection
  - CORS configuration
  - Role-based endpoint security

