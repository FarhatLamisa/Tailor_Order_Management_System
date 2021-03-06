USE [master]
GO
/****** Object:  Database [TailorDBproject]    Script Date: 23-Sep-20 4:52:00 AM ******/
CREATE DATABASE [TailorDBproject] ON  PRIMARY 
( NAME = N'TailorDBproject', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\TailorDBproject.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TailorDBproject_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\TailorDBproject_log.LDF' , SIZE = 504KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TailorDBproject] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TailorDBproject].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TailorDBproject] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TailorDBproject] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TailorDBproject] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TailorDBproject] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TailorDBproject] SET ARITHABORT OFF 
GO
ALTER DATABASE [TailorDBproject] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [TailorDBproject] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TailorDBproject] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TailorDBproject] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TailorDBproject] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TailorDBproject] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TailorDBproject] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TailorDBproject] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TailorDBproject] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TailorDBproject] SET  ENABLE_BROKER 
GO
ALTER DATABASE [TailorDBproject] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TailorDBproject] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TailorDBproject] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TailorDBproject] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TailorDBproject] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TailorDBproject] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TailorDBproject] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TailorDBproject] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TailorDBproject] SET  MULTI_USER 
GO
ALTER DATABASE [TailorDBproject] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TailorDBproject] SET DB_CHAINING OFF 
GO
USE [TailorDBproject]
GO
/****** Object:  Table [dbo].[Casual_Dress_Orders]    Script Date: 23-Sep-20 4:52:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Casual_Dress_Orders](
	[Cas_Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NOT NULL,
	[Dress_Disign] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[Cas_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 23-Sep-20 4:52:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Pass] [varchar](50) NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[CustomerAddress] [varchar](50) NOT NULL,
	[CustomerContact] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Design]    Script Date: 23-Sep-20 4:52:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Design](
	[DesignID] [int] IDENTITY(1,1) NOT NULL,
	[Design] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[DesignID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 23-Sep-20 4:52:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NOT NULL,
	[TailorId] [int] NOT NULL,
	[DesignId] [int] NULL,
	[fee] [float] NOT NULL,
	[OrderDate] [date] NOT NULL,
	[Height] [float] NULL,
	[Neck] [float] NULL,
	[Waist] [float] NULL,
	[Shoulder] [float] NULL,
	[Arm] [float] NULL,
	[Wrist] [float] NULL,
	[Thighs] [float] NULL,
	[Chest] [float] NULL,
	[DressType] [varchar](50) NULL,
	[CompletingDate] [date] NOT NULL,
	[Completed] [varchar](5) NULL DEFAULT ('NO'),
	[ExtraDescribe] [varchar](500) NULL,
	[Emergency_make] [varchar](5) NULL,
	[Image] [image] NULL,
	[ImagePath] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Party_Dress_Orders]    Script Date: 23-Sep-20 4:52:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Party_Dress_Orders](
	[Par_Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NOT NULL,
	[Dress_Disign] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[Par_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tailor]    Script Date: 23-Sep-20 4:52:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tailor](
	[TailorID] [int] IDENTITY(1,1) NOT NULL,
	[TailorName] [varchar](50) NOT NULL,
	[TailorEmail] [varchar](50) NOT NULL,
	[TailorContact] [int] NOT NULL,
	[TailorPass] [varchar](50) NOT NULL,
	[TailorAddress] [varchar](100) NULL DEFAULT ('Not given'),
PRIMARY KEY CLUSTERED 
(
	[TailorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[TailorEmail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Casual_Dress_Orders]  WITH CHECK ADD FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([CustomerID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([DesignId])
REFERENCES [dbo].[Design] ([DesignID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([TailorId])
REFERENCES [dbo].[Tailor] ([TailorID])
GO
ALTER TABLE [dbo].[Party_Dress_Orders]  WITH CHECK ADD FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([OrderID])
GO
USE [master]
GO
ALTER DATABASE [TailorDBproject] SET  READ_WRITE 
GO
