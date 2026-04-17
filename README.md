# DG Notes

Production-style mini Android Notes app using **Clean Architecture + MVVM + Supabase**.

## Features
- Add, list, update, and delete notes.
- Layered architecture (`domain`, `data`, `app`).
- Jetpack Compose UI.
- Supabase integration (PostgREST/Auth/Realtime plugin-ready).

## Setup
1. Create a Supabase table:
   ```sql
   create extension if not exists "uuid-ossp";

   create table if not exists notes (
     id uuid default uuid_generate_v4() primary key,
     content text not null,
     created_at timestamp with time zone default now(),
     user_id uuid
   );
   ```
2. Put keys in `gradle.properties`:
   ```properties
   SUPABASE_URL=https://YOUR_PROJECT.supabase.co
   SUPABASE_ANON_KEY=YOUR_ANON_KEY
   ```
3. Build:
   ```bash
   gradle :app:assembleDebug
   ```

## Structure
- `app/src/main/java/com/dgnotes/app/*` → UI, navigation, DI, viewmodels
- `app/src/main/java/com/dgnotes/domain/*` → models, repositories, use cases
- `app/src/main/java/com/dgnotes/data/*` → Supabase client and repository implementation
