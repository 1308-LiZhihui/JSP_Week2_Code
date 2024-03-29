USE [UserDB]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 2022/4/26 21:23:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[PatmentId] [int] NOT NULL,
	[PaymentType] [nvarchar](100) NULL,
	[Allowed] [bit] NULL,
 CONSTRAINT [Payment_pk] PRIMARY KEY CLUSTERED 
(
	[PatmentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
